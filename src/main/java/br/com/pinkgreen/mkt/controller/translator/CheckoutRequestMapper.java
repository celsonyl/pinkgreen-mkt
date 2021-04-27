package br.com.pinkgreen.mkt.controller.translator;

import br.com.pinkgreen.mkt.controller.model.CheckoutRequest;
import br.com.pinkgreen.mkt.domain.Checkout;
import org.mapstruct.Mapper;

@Mapper
public interface CheckoutRequestMapper {

    Checkout checkoutRequestToCheckout(CheckoutRequest checkoutRequest);
    CheckoutRequest checkoutToCheckoutRequest(Checkout checkout);
}
