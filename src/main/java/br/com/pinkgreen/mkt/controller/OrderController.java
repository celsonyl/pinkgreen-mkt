package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.model.CheckoutOrderResponse;
import br.com.pinkgreen.mkt.controller.model.OrderRequest;
import br.com.pinkgreen.mkt.controller.translator.OrderRequestMapperImpl;
import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.usecase.CheckoutOrderUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@Slf4j
@Component
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController implements OrderControllerApi {

    private final CheckoutOrderUseCase checkoutOrderUseCase;

    @Override
    @PostMapping
    @RolesAllowed("user")
    public ResponseEntity<CheckoutOrderResponse> checkout(OrderRequest orderRequest) {
        log.info("[CONTROLLER] Receiving new order request");
        var orderDomain = new OrderRequestMapperImpl().orderRequestToOrder(orderRequest);
        OrderDomain orderCreated = checkoutOrderUseCase.execute(orderDomain, orderDomain.getPaymentData());
        return ResponseEntity.ok().body(CheckoutOrderResponse.builder()
                .orderId(orderCreated.getId())
                .customerId(orderCreated.getCustomerData().getId())
                .message("Pedido recebido!")
                .build());
    }
}

