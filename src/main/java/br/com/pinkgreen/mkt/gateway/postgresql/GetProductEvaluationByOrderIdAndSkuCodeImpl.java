package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductEvaluationDomain;
import br.com.pinkgreen.mkt.gateway.GetProductEvaluationByOrderIdAndSkuCode;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductEvaluationDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductEvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductEvaluationByOrderIdAndSkuCodeImpl implements GetProductEvaluationByOrderIdAndSkuCode {

    private final ProductEvaluationRepository repository;

    public GetProductEvaluationByOrderIdAndSkuCodeImpl(ProductEvaluationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ProductEvaluationDomain> execute(Integer orderId, String skuCode) {
        return repository.findByOrderIdAndSkuCode(orderId, skuCode)
                .map(ProductEvaluationDatabase::domain);
    }
}
