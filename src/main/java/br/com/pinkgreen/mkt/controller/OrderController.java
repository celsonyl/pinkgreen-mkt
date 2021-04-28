package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.model.CheckoutOrderResponse;
import br.com.pinkgreen.mkt.controller.model.OrderRequest;
import br.com.pinkgreen.mkt.controller.translator.CheckoutRequestMapperImpl;
import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.usecase.CheckoutOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Component
@RestController("/order")
@RequiredArgsConstructor
public class OrderController {

    private final CheckoutOrderUseCase checkoutOrderUseCase;

    @PostMapping
    public CheckoutOrderResponse checkout(@Valid OrderRequest orderRequest) {
        OrderDomain orderDomain = new CheckoutRequestMapperImpl().checkoutRequestToCheckout(orderRequest);
        checkoutOrderUseCase.execute(orderDomain);
        return null;
    }
}
