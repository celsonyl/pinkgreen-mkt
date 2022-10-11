package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.SaveOrderGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.pinkgreen.mkt.gateway.postgresql.model.OrderDatabase.database;

@Component
@RequiredArgsConstructor
public class SaveOrderGatewayImpl implements SaveOrderGateway {

    private final OrderRepository orderRepository;

    @Override
    public OrderDomain execute(OrderDomain order) {
        return orderRepository.save(database(order)).toDomain();
    }
}
