package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.GetAllOrdersByCustomerIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllOrdersByCustomerIdUseCase {

    private final GetAllOrdersByCustomerIdGateway getAllOrdersByCustomerIdGateway;

    public List<OrderDomain> execute(String customerId) {
        return getAllOrdersByCustomerIdGateway.execute(customerId);
    }
}
