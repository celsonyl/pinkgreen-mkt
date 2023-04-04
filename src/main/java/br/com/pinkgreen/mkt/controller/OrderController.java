package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.OrderControllerApi;
import br.com.pinkgreen.mkt.controller.model.OrderRequest;
import br.com.pinkgreen.mkt.controller.model.OrderResponse;
import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.exception.OrderNotFoundException;
import br.com.pinkgreen.mkt.gateway.FindCustomerById;
import br.com.pinkgreen.mkt.gateway.FindOrderById;
import br.com.pinkgreen.mkt.usecase.CheckoutOrderUseCase;
import br.com.pinkgreen.mkt.usecase.GetAllOrdersByCustomerIdUseCase;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static br.com.pinkgreen.mkt.controller.model.OrderResponse.response;
import static br.com.pinkgreen.mkt.controller.util.VerifyCustomerId.getCustomerIdAndValidate;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@Component
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController implements OrderControllerApi {

    private final FindCustomerById findCustomerById;
    private final CheckoutOrderUseCase checkoutOrderUseCase;
    private final FindOrderById findOrderById;
    private final GetAllOrdersByCustomerIdUseCase getAllOrdersByCustomerIdUseCase;

    @Override
    @SneakyThrows
    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<OrderResponse> checkout(OrderRequest orderRequest, HttpServletRequest request) {
        log.info("[CONTROLLER] Receiving new order request");
        String customerId = orderRequest.getCustomerId();
        getCustomerIdAndValidate((JwtAuthenticationToken) request.getUserPrincipal(), customerId);
        OrderDomain order = checkoutOrderUseCase.execute(
                orderRequest.data(findCustomerById.execute(customerId)),
                orderRequest.getPaymentData().toDomain()
        );

        return ok(response(order));
    }

    @Override
    @SneakyThrows
    @GetMapping("/{orderId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<OrderResponse> getOrderById(Integer orderId, HttpServletRequest request) {
        OrderDomain order = findOrderById.execute(orderId).orElseThrow(OrderNotFoundException::new);
        getCustomerIdAndValidate((JwtAuthenticationToken) request.getUserPrincipal(), order.getCustomerData().getId());
        return ok(response(order));
    }

    @Override
    @SneakyThrows
    @GetMapping("/customer/{customerId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<OrderResponse>> getOrdersByCustomerId(String customerId, HttpServletRequest request) {
        getCustomerIdAndValidate((JwtAuthenticationToken) request.getUserPrincipal(), customerId);
        List<OrderDomain> orders = getAllOrdersByCustomerIdUseCase.execute(customerId);

        return ok(orders.stream()
                .map(OrderResponse::response)
                .collect(toList()));
    }

}

