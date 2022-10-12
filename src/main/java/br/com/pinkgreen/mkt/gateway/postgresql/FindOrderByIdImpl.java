package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.FindOrderById;
import br.com.pinkgreen.mkt.gateway.postgresql.model.OrderDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindOrderByIdImpl implements FindOrderById {
    private final OrderRepository repository;

    public FindOrderByIdImpl(OrderRepository repository) {this.repository = repository;}

    @Override
    public Optional<OrderDomain> execute(Integer orderId) {
        return repository.findById(orderId).map(OrderDatabase::toDomain);
    }
}
