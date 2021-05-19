package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.GetAllOrdersByCustomerIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.OrderDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.translator.OrderDatabaseMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetAllOrdersByCustomerIdGatewayImpl implements GetAllOrdersByCustomerIdGateway {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderDomain> execute(String customerId) {
        List<OrderDatabase> ordersDatabase = orderRepository.findAllOrdersByCustomerId(customerId);

        return ordersDatabase.stream().map(new OrderDatabaseMapperImpl()::orderDatabaseToOrder).collect(Collectors.toList());
    }
}
