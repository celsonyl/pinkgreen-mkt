package br.com.pinkgreen.mkt.usecase.factory.strategies;

import br.com.pinkgreen.mkt.domain.PaymentData;
import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import br.com.pinkgreen.mkt.gateway.RequestCardPaymentGateway;
import br.com.pinkgreen.mkt.gateway.SaveOrderGateway;
import br.com.pinkgreen.mkt.usecase.FindOrderByIdUseCase;
import br.com.pinkgreen.mkt.usecase.VerifyAndReserveProductStockUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.pinkgreen.mkt.domain.enums.OrderStatus.PAYMENT_CONFIRMED;
import static br.com.pinkgreen.mkt.domain.enums.PaymentMethod.CREDIT_CARD;
import static br.com.pinkgreen.mkt.domain.enums.PaymentMethod.DEBIT_CARD;

@Component
@RequiredArgsConstructor
public class RequestPaymentCardStrategy implements RequestPaymentStrategy {

    private final RequestCardPaymentGateway requestCardPaymentGateway;
    private final FindOrderByIdUseCase findOrderByIdUseCase;
    private final SaveOrderGateway saveOrderGateway;
    private final VerifyAndReserveProductStockUseCase verifyAndReserveProductStockUseCase;

    @Override
    public void execute(Integer orderId, PaymentData paymentData) {
        var orderDomain = findOrderByIdUseCase.execute(orderId);

        var payment = requestCardPaymentGateway.execute(orderDomain.getSubtotal(), paymentData);

        orderDomain.setStatus(PAYMENT_CONFIRMED);
        orderDomain.setPaymentData(payment);
        orderDomain.setUpdatedAt();

        saveOrderGateway.execute(orderDomain);
        verifyAndReserveProductStockUseCase.execute(orderDomain);
    }

    @Override
    public boolean supports(PaymentMethod paymentMethod) {
        return paymentMethod.equals(DEBIT_CARD) || paymentMethod.equals(CREDIT_CARD);
    }
}
