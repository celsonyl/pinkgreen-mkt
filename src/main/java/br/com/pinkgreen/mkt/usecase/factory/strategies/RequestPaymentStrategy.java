package br.com.pinkgreen.mkt.usecase.factory.strategies;

import br.com.pinkgreen.mkt.domain.PaymentData;
import br.com.pinkgreen.mkt.domain.PaymentDomain;
import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;

public interface RequestPaymentStrategy {

    void execute(Integer orderId, PaymentData paymentData);

    boolean supports(PaymentMethod paymentMethod);
}
