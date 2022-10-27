package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductEvaluationDomain;
import br.com.pinkgreen.mkt.gateway.CreateProductEvaluationGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductEvaluationRepository;
import org.springframework.stereotype.Component;

import static br.com.pinkgreen.mkt.gateway.postgresql.model.ProductEvaluationDatabase.database;

@Component
public class CreateProductEvaluationGatewayImpl implements CreateProductEvaluationGateway {

    private final ProductEvaluationRepository repository;

    public CreateProductEvaluationGatewayImpl(ProductEvaluationRepository productEvaluationRepository) {this.repository = productEvaluationRepository;}

    @Override
    public ProductEvaluationDomain execute(ProductEvaluationDomain productEvaluationDomain) {
        return repository.save(database(productEvaluationDomain)).domain();
    }
}
