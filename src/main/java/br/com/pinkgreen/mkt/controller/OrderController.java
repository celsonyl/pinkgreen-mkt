package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.OrderControllerApi;
import br.com.pinkgreen.mkt.controller.model.CheckoutOrderResponse;
import br.com.pinkgreen.mkt.controller.model.OrderRequest;
import br.com.pinkgreen.mkt.controller.model.OrderResponse;
import br.com.pinkgreen.mkt.domain.CustomerDomain;
import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import br.com.pinkgreen.mkt.domain.exception.InvalidCustomerIdException;
import br.com.pinkgreen.mkt.gateway.FindCustomerById;
import br.com.pinkgreen.mkt.translator.OrderMapperImpl;
import br.com.pinkgreen.mkt.usecase.CheckoutOrderUseCase;
import br.com.pinkgreen.mkt.usecase.GetAllOrdersByCustomerIdUseCase;
import br.com.pinkgreen.mkt.usecase.GetAllOrdersReadyToShipUseCase;
import br.com.pinkgreen.mkt.usecase.UpdateAndPublishOrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController implements OrderControllerApi {

    private final FindCustomerById findCustomerById;
    private final CheckoutOrderUseCase checkoutOrderUseCase;
    private final GetAllOrdersByCustomerIdUseCase getAllOrdersByCustomerIdUseCase;
    private final GetAllOrdersReadyToShipUseCase getAllOrdersReadyToShipUseCase;
    private final UpdateAndPublishOrderEvent updateAndPublishOrderEvent;

    @Override
    @SneakyThrows
    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<CheckoutOrderResponse> checkout(OrderRequest orderRequest, HttpServletRequest request) {
        log.info("[CONTROLLER] Receiving new order request");
        String customerId = orderRequest.getCustomerId();

        getCustomerIdAndValidate((JwtAuthenticationToken) request.getUserPrincipal(), customerId);

        CustomerDomain customer = findCustomerById.execute(customerId);
        var orderDomain = new OrderMapperImpl().orderRequestToOrder(orderRequest);
        orderDomain.setCustomerData(customer);
        OrderDomain orderCreated = checkoutOrderUseCase.execute(orderDomain);
        return ResponseEntity.ok().body(CheckoutOrderResponse.builder()
                .orderId(orderCreated.getId())
                .customerId(orderCreated.getCustomerData().getId())
                .message("Pedido recebido!")
                .build());
    }

    @Override
    @SneakyThrows
    @GetMapping("/customer/{customerId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<OrderResponse>> getOrdersByCustomerId(String customerId, HttpServletRequest request) {
        getCustomerIdAndValidate((JwtAuthenticationToken) request.getUserPrincipal(), customerId);

        List<OrderDomain> orders = getAllOrdersByCustomerIdUseCase.execute(customerId);

        List<OrderResponse> orderResponses = orders.stream().map(new OrderMapperImpl()::orderToOrderResponse).collect(Collectors.toList());

        return ResponseEntity.ok(orderResponses);
    }

    @Override
    @SneakyThrows
    @GetMapping("/state/ready-to-ship")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<OrderResponse>> getOrdersReadyToShip() {
        var orders = getAllOrdersReadyToShipUseCase.execute();
        return ResponseEntity.ok(orders.stream()
                .map(new OrderMapperImpl()::orderToOrderResponse)
                .collect(Collectors.toList()));
    }

    @Override
    @PatchMapping("/{orderId}/update/{orderStatus}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> updateOrderStatus(String orderId, OrderStatus orderStatus) {
        updateAndPublishOrderEvent.execute(orderId, orderStatus);
        return ResponseEntity.noContent().build();
    }

    private void getCustomerIdAndValidate(JwtAuthenticationToken authenticationToken, String customerId) throws InvalidCustomerIdException {
        String tokenCustomerId = authenticationToken.getToken().getSubject();

        if (!customerId.equals(tokenCustomerId)) {
            throw new InvalidCustomerIdException("[CONTROLLER] Invalid customerId");
        }
    }
}

