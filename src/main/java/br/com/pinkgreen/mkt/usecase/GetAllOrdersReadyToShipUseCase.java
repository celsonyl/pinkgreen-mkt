package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import br.com.pinkgreen.mkt.domain.exception.ObjectNotFoundException;
import br.com.pinkgreen.mkt.gateway.GetAllOrdersByStatusGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllOrdersReadyToShipUseCase {

    private final GetAllOrdersByStatusGateway getAllOrdersByStatusGateway;

    public List<OrderDomain> execute() {
        List<OrderDomain> execute = getAllOrdersByStatusGateway.execute(OrderStatus.ORDER_STOCK_RESERVED);

        if (execute.size() == 0) {
            throw new ObjectNotFoundException("Does not have orders ready to go");
        }
        return execute;
    }
}