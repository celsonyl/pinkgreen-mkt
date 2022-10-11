package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import br.com.pinkgreen.mkt.gateway.GetAllOrdersByStatusGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.OrderDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class GetAllOrdersByStatusGatewayImpl implements GetAllOrdersByStatusGateway {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderDomain> execute(OrderStatus orderStatus) {
        return orderRepository.findAllOrdersByStatus(orderStatus).stream()
                .map(OrderDatabase::toDomain)
                .collect(toList());
    }
}
