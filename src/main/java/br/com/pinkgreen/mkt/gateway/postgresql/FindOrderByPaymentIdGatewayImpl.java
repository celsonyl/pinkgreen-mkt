package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.FindOrderByPaymentIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.OrderDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.OrderLogRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static br.com.pinkgreen.mkt.gateway.postgresql.model.OrderLogDatabase.domain;

@Component
@RequiredArgsConstructor
public class FindOrderByPaymentIdGatewayImpl implements FindOrderByPaymentIdGateway {

    private final OrderRepository orderRepository;
    private final OrderLogRepository logRepository;

    @Override
    public Optional<OrderDomain> execute(String paymentId) {
        return orderRepository.findOrderByPaymentId(paymentId)
                .map(OrderDatabase::toDomain)
                .map(it -> {
                    it.setHistory(domain(logRepository.findAllByOrderId(it.getId())));
                    return it;
                });
    }
}
