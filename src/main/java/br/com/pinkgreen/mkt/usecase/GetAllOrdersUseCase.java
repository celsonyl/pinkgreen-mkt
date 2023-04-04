package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.exception.ObjectNotFoundException;
import br.com.pinkgreen.mkt.gateway.GetAllOrdersGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllOrdersUseCase {

    private final GetAllOrdersGateway getAllOrdersGateway;

    public List<OrderDomain> execute() {
        List<OrderDomain> orders = getAllOrdersGateway.execute();

        if (orders.size() == 0) {
            throw new ObjectNotFoundException("No order found");
        }
        return orders;
    }
}