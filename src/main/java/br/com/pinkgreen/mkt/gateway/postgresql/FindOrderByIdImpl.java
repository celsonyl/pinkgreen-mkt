package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.FindOrderById;
import br.com.pinkgreen.mkt.gateway.postgresql.model.OrderDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.OrderLogRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.pinkgreen.mkt.gateway.postgresql.model.OrderLogDatabase.domain;

@Service
public class FindOrderByIdImpl implements FindOrderById {
    private final OrderLogRepository logRepository;
    private final OrderRepository repository;

    public FindOrderByIdImpl(OrderLogRepository logRepository, OrderRepository repository) {
        this.logRepository = logRepository;
        this.repository = repository;
    }

    @Override
    public Optional<OrderDomain> execute(Integer orderId) {
        return repository.findById(orderId)
                .map(OrderDatabase::toDomain)
                .map(it -> {
                    it.setHistory(domain(logRepository.findAllByOrderId(it.getId())));
                    return it;
                });
    }
}
