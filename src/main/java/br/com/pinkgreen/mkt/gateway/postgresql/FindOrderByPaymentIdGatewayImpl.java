package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.FindOrderByPaymentIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.OrderDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindOrderByPaymentIdGatewayImpl implements FindOrderByPaymentIdGateway {

    private final OrderRepository orderRepository;

    @Override
    public Optional<OrderDomain> execute(String paymentId) {
        return orderRepository.findOrderByPaymentId(paymentId).map(OrderDatabase::toDomain);
    }
}
