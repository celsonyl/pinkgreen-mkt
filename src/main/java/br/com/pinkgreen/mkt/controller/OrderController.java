package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.exception.InvalidCustomerIdException;
import br.com.pinkgreen.mkt.controller.model.CheckoutOrderResponse;
import br.com.pinkgreen.mkt.controller.model.OrderRequest;
import br.com.pinkgreen.mkt.controller.model.OrderResponse;
import br.com.pinkgreen.mkt.controller.translator.OrderRequestMapperImpl;
import br.com.pinkgreen.mkt.controller.translator.OrderResponseMapperImpl;
import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.usecase.CheckoutOrderUseCase;
import br.com.pinkgreen.mkt.usecase.GetAllOrdersByCustomerIdUseCase;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController implements OrderControllerApi {

    private final CheckoutOrderUseCase checkoutOrderUseCase;
    private final GetAllOrdersByCustomerIdUseCase getAllOrdersByCustomerIdUseCase;

    @Override
    @SneakyThrows
    @PostMapping
    @RolesAllowed("user")
    public ResponseEntity<CheckoutOrderResponse> checkout(OrderRequest orderRequest, HttpServletRequest request) {
        log.info("[CONTROLLER] Receiving new order request");
        String customerId = orderRequest.getCustomerData().getId();

        getCustomerIdAndValidate((KeycloakAuthenticationToken) request.getUserPrincipal(), customerId);

        var orderDomain = new OrderRequestMapperImpl().orderRequestToOrder(orderRequest);
        OrderDomain orderCreated = checkoutOrderUseCase.execute(orderDomain, orderDomain.getPaymentData());
        return ResponseEntity.ok().body(CheckoutOrderResponse.builder()
                .orderId(orderCreated.getId())
                .customerId(orderCreated.getCustomerData().getId())
                .message("Pedido recebido!")
                .build());
    }

    @Override
    @SneakyThrows
    @GetMapping("/{customerId}")
    @RolesAllowed("user")
    public ResponseEntity<List<OrderResponse>> getOrdersByCustomerId(String customerId, HttpServletRequest request) {
        getCustomerIdAndValidate((KeycloakAuthenticationToken) request.getUserPrincipal(), customerId);

        List<OrderDomain> orders = getAllOrdersByCustomerIdUseCase.execute(customerId);

        List<OrderResponse> orderResponses = orders.stream().map(new OrderResponseMapperImpl()::orderToOrderResponse).collect(Collectors.toList());

        return ResponseEntity.ok(orderResponses);
    }


    private void getCustomerIdAndValidate(KeycloakAuthenticationToken keycloakAuthenticationToken, String customerId) throws InvalidCustomerIdException {
        String tokenCustomerId = keycloakAuthenticationToken.getAccount().getKeycloakSecurityContext().getToken().getSubject();

        if (!customerId.equals(tokenCustomerId)) {
            throw new InvalidCustomerIdException("[CONTROLLER] Invalid customerId");
        }
    }
}

