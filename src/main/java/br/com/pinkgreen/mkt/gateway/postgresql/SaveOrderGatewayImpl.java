package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.SaveOrderGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.OrderRepository;
import br.com.pinkgreen.mkt.translator.OrderMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveOrderGatewayImpl implements SaveOrderGateway {

    private final OrderRepository orderRepository;

    @Override
    public OrderDomain execute(OrderDomain orderDomain) {
        var orderDatabaseMapper = new OrderMapperImpl();
        var orderDatabase = orderDatabaseMapper.orderToOrderDatabase(orderDomain);
        return orderDatabaseMapper.orderDatabaseToOrder(orderRepository.save(orderDatabase));
    }
}
