package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.CheckoutOrderGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.OrderDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.translator.OrderDatabaseMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class CheckoutOrderGatewayImpl implements CheckoutOrderGateway {

    private final OrderRepository orderRepository;

    @Override
    public OrderDomain execute(OrderDomain orderDomain) {
        OrderDatabaseMapperImpl orderDatabaseMapper = new OrderDatabaseMapperImpl();
        OrderDatabase orderDatabase = orderDatabaseMapper.orderToOrderDatabase(orderDomain);

        orderDatabase.setCreatedAt(Instant.now());

        return orderDatabaseMapper.orderDatabaseToOrder(orderRepository.save(orderDatabase));
    }
}
