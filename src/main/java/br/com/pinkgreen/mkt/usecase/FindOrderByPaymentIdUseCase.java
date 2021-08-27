package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.exception.ObjectNotFoundException;
import br.com.pinkgreen.mkt.gateway.FindOrderByPaymentIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindOrderByPaymentIdUseCase {

    private final FindOrderByPaymentIdGateway findOrderByPaymentIdGateway;

    public OrderDomain execute(String paymentId) {
        return findOrderByPaymentIdGateway.execute(paymentId)
                .orElseThrow(() -> new ObjectNotFoundException("[USE_CASE] Order not found - paymentId: " + paymentId));
    }
}