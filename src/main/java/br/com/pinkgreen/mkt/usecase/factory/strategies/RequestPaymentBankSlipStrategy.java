package br.com.pinkgreen.mkt.usecase.factory.strategies;

import br.com.pinkgreen.mkt.domain.PaymentDomain;
import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestPaymentBankSlipStrategy implements RequestPaymentStrategy {
    @Override
    public void execute(PaymentDomain paymentDomain) {

    }

    @Override
    public boolean supports(PaymentMethod paymentMethod) {
        return paymentMethod.equals(PaymentMethod.BANK_SLIP);
    }
}
