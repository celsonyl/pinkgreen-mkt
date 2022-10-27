package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductEvaluationDomain;
import br.com.pinkgreen.mkt.gateway.GetProductEvaluationByOrderId;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductEvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.pinkgreen.mkt.gateway.postgresql.model.ProductEvaluationDatabase.domain;

@Service
public class GetProductEvaluationByOrderIdImpl implements GetProductEvaluationByOrderId {

    private final ProductEvaluationRepository repository;

    public GetProductEvaluationByOrderIdImpl(ProductEvaluationRepository repository) {this.repository = repository;}

    @Override
    public List<ProductEvaluationDomain> execute(Integer orderId) {
        return domain(repository.findAllByOrderId(orderId));
    }
}
