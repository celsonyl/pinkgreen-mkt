package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.PaymentData;
import br.com.pinkgreen.mkt.domain.PaymentDomain;
import br.com.pinkgreen.mkt.domain.exception.PaymentStrategyNotFound;
import br.com.pinkgreen.mkt.usecase.factory.RequestPaymentFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RequestPaymentUseCase {

    private final RequestPaymentFactory requestPaymentFactory;

    public void execute(Integer orderId, PaymentData paymentData) throws PaymentStrategyNotFound {
        var paymentMethodStrategy = requestPaymentFactory.getPaymentMethodStrategy(paymentData.getPaymentMethod());

        if (paymentMethodStrategy.isPresent()) {
            paymentMethodStrategy.get().execute(orderId, paymentData);
            return;
        }
        throw new PaymentStrategyNotFound("[USE_CASE] Can not find repaymentMethodStrategy request payment strategy");
    }
}
