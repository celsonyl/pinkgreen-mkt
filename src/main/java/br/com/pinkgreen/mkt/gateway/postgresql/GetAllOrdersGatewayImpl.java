package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.GetAllOrdersGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.OrderDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.OrderLogRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static br.com.pinkgreen.mkt.gateway.postgresql.model.OrderLogDatabase.domain;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class GetAllOrdersGatewayImpl implements GetAllOrdersGateway {

    private final OrderRepository orderRepository;
    private final OrderLogRepository logRepository;

    @Override
    public List<OrderDomain> execute() {
        return orderRepository.findAll().stream()
                .map(OrderDatabase::toDomain)
                .peek(it -> it.setHistory(domain(logRepository.findAllByOrderId(it.getId()))))
                .collect(toList());
    }
}
