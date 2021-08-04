package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.exception.ObjectNotFoundException;
import br.com.pinkgreen.mkt.gateway.FindOrderByIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindOrderByIdUseCase {

    private final FindOrderByIdGateway findOrderByIdGateway;

    public OrderDomain execute(String orderId) {
        return findOrderByIdGateway.execute(Integer.parseInt(orderId))
                .orElseThrow(() -> new ObjectNotFoundException("[USE_CASE] Order not found - orderId: " + orderId));
    }
}