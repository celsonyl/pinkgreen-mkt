package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductEvaluationDomain;
import br.com.pinkgreen.mkt.gateway.GetProductEvaluationByCustomerId;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductEvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.pinkgreen.mkt.gateway.postgresql.model.ProductEvaluationDatabase.domain;

@Service
public class GetProductEvaluationByCustomerIdImpl implements GetProductEvaluationByCustomerId {

    private final ProductEvaluationRepository repository;

    public GetProductEvaluationByCustomerIdImpl(ProductEvaluationRepository repository) {this.repository = repository;}

    @Override
    public List<ProductEvaluationDomain> execute(String customerId) {
        return domain(repository.findAllByCustomerId(customerId));
    }
}
