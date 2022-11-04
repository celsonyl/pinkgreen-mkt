package br.com.pinkgreen.mkt.usecase.factory.strategies;

import br.com.pinkgreen.mkt.domain.PaymentData;
import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import br.com.pinkgreen.mkt.gateway.RequestBankSlipPaymentGateway;
import br.com.pinkgreen.mkt.gateway.SaveOrderGateway;
import br.com.pinkgreen.mkt.usecase.FindOrderByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.pinkgreen.mkt.domain.enums.OrderStatus.PAYMENT_REQUESTED;
import static br.com.pinkgreen.mkt.domain.enums.PaymentMethod.BANK_SLIP;

@Component
@RequiredArgsConstructor
public class RequestPaymentBankSlipStrategy implements RequestPaymentStrategy {

    private final RequestBankSlipPaymentGateway requestPayment;
    private final FindOrderByIdUseCase findOrderByIdUseCase;
    private final SaveOrderGateway saveOrderGateway;

    @Override
    public void execute(Integer orderId, PaymentData paymentData) {
        var orderDomain = findOrderByIdUseCase.execute(orderId);

        var payment = requestPayment.execute(orderDomain.getSubtotal(), paymentData);

        orderDomain.setStatus(PAYMENT_REQUESTED);
        orderDomain.setPaymentData(payment);
        orderDomain.setUpdatedAt();

        saveOrderGateway.execute(orderDomain);
    }

    @Override
    public boolean supports(PaymentMethod paymentMethod) {
        return paymentMethod.equals(BANK_SLIP);
    }
}
