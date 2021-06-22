package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.PaymentDomain;
import br.com.pinkgreen.mkt.usecase.factory.RequestPaymentFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RequestPaymentUseCase {

    private final RequestPaymentFactory requestPaymentFactory;

    public void execute(String orderId, PaymentDomain paymentDomain) {

    }
}
