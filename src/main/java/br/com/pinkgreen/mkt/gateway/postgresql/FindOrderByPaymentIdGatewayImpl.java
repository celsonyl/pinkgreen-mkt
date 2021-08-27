package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.FindOrderByPaymentIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.OrderRepository;
import br.com.pinkgreen.mkt.translator.OrderMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindOrderByPaymentIdGatewayImpl implements FindOrderByPaymentIdGateway {

    private final OrderRepository orderRepository;

    @Override
    public Optional<OrderDomain> execute(String paymentId) {
        var order = orderRepository.findOrderByPaymentId(paymentId);
        return order.map(new OrderMapperImpl()::orderDatabaseToOrder);
    }
}
