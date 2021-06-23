package br.com.pinkgreen.mkt.usecase.factory.strategies;

import br.com.pinkgreen.mkt.domain.PaymentDomain;
import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;

public interface RequestPaymentStrategy {

    void execute(String orderId, PaymentDomain paymentDomain);

    boolean supports(PaymentMethod paymentMethod);
}
