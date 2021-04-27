package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.model.CheckoutRequest;
import br.com.pinkgreen.mkt.controller.translator.CheckoutRequestMapperImpl;
import br.com.pinkgreen.mkt.usecase.CheckoutUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Component
@RestController("/checkout")
@RequiredArgsConstructor
public class CheckoutController {

    private final CheckoutUseCase checkoutUseCase;

    @PostMapping
    public Object checkout(@Valid CheckoutRequest checkoutRequest) {
        checkoutUseCase.execute(new CheckoutRequestMapperImpl().checkoutRequestToCheckout(checkoutRequest));
        return null;
    }
}
