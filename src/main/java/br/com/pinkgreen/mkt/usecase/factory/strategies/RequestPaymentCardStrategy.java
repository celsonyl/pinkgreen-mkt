package br.com.pinkgreen.mkt.usecase.factory.strategies;

import br.com.pinkgreen.mkt.domain.PaymentDomain;
import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import br.com.pinkgreen.mkt.gateway.RequestCardPaymentGateway;
import br.com.pinkgreen.mkt.usecase.FindOrderByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestPaymentCardStrategy implements RequestPaymentStrategy {

    private final RequestCardPaymentGateway requestCardPaymentGateway;
    private final FindOrderByIdUseCase findOrderByIdUseCase;

    @Override
    public void execute(String orderId, PaymentDomain paymentDomain) {
        var orderDomain = findOrderByIdUseCase.execute(orderId);
        orderDomain.setPaymentData(paymentDomain);

        var paymentId = requestCardPaymentGateway.execute(orderDomain);
        orderDomain.getPaymentData().setPaymentId(paymentId);
        // TODO: SALVAR PAYMENTID E ATUALIZAR STATUS DO PEDIDO PARA AWAITING_PAYMENT_CONFIRM
    }

    @Override
    public boolean supports(PaymentMethod paymentMethod) {
        return paymentMethod.equals(PaymentMethod.DEBIT_CARD) || paymentMethod.equals(PaymentMethod.CREDIT_CARD);
    }
}
