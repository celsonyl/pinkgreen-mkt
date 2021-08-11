package br.com.pinkgreen.mkt.usecase.factory.strategies;

import br.com.pinkgreen.mkt.domain.PaymentDomain;
import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import br.com.pinkgreen.mkt.gateway.RequestCardPaymentGateway;
import br.com.pinkgreen.mkt.gateway.SaveOrderGateway;
import br.com.pinkgreen.mkt.usecase.FindOrderByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

import static br.com.pinkgreen.mkt.domain.enums.OrderStatus.AWAITING_PAYMENT_CONFIRM;

@Component
@RequiredArgsConstructor
public class RequestPaymentCardStrategy implements RequestPaymentStrategy {

    private final RequestCardPaymentGateway requestCardPaymentGateway;
    private final FindOrderByIdUseCase findOrderByIdUseCase;
    private final SaveOrderGateway saveOrderGateway;

    @Override
    public void execute(String orderId, PaymentDomain paymentDomain) {
        var orderDomain = findOrderByIdUseCase.execute(orderId);
        orderDomain.setPaymentData(paymentDomain);

        var paymentId = requestCardPaymentGateway.execute(orderDomain);

        orderDomain.setStatus(AWAITING_PAYMENT_CONFIRM);
        orderDomain.getPaymentData().setPaymentId(paymentId);
        orderDomain.setUpdatedAt(Instant.now());

        saveOrderGateway.execute(orderDomain);
    }

    @Override
    public boolean supports(PaymentMethod paymentMethod) {
        return paymentMethod.equals(PaymentMethod.DEBIT_CARD) || paymentMethod.equals(PaymentMethod.CREDIT_CARD);
    }
}
