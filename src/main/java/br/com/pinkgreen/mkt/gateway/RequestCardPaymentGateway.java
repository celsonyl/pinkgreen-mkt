package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.PaymentData;
import br.com.pinkgreen.mkt.domain.PaymentDomain;

public interface RequestCardPaymentGateway {

    PaymentDomain execute(Double subtotal, PaymentData paymentData);
}
