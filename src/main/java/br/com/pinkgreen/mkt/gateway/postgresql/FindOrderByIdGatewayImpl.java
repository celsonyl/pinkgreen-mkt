package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.FindOrderByIdGateway;
import br.com.pinkgreen.mkt.translator.OrderMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindOrderByIdGatewayImpl implements FindOrderByIdGateway {

    private final OrderRepository orderRepository;

    @Override
    public Optional<OrderDomain> execute(Integer id) {
        var orderDatabase = orderRepository.findById(id);

        return orderDatabase.map(database -> new OrderMapperImpl().orderDatabaseToOrder(database));
    }
}
