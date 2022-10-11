package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.GetAllOrdersByCustomerIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.OrderDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class GetAllOrdersByCustomerIdGatewayImpl implements GetAllOrdersByCustomerIdGateway {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderDomain> execute(String customerId) {
        return orderRepository.findAllOrdersByCustomerId(customerId)
                .stream()
                .map(OrderDatabase::toDomain)
                .collect(toList());
    }
}
