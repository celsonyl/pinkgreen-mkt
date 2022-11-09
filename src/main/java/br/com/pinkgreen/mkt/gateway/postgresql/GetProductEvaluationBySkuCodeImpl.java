package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductEvaluationBySkuCode;
import br.com.pinkgreen.mkt.gateway.GetProductEvaluationBySkuCode;
import br.com.pinkgreen.mkt.gateway.postgresql.model.IProductEvaluationMetadata;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductEvaluationDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductEvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.pinkgreen.mkt.domain.ProductEvaluationBySkuCode.evaluation;
import static br.com.pinkgreen.mkt.gateway.postgresql.model.ProductEvaluationDatabase.domain;

@Service
@RequiredArgsConstructor
public class GetProductEvaluationBySkuCodeImpl implements GetProductEvaluationBySkuCode {

    private final ProductEvaluationRepository repository;

    @Override
    public ProductEvaluationBySkuCode execute(String skuCode) {
        List<ProductEvaluationDatabase> data = repository.findAllBySkuCode(skuCode);
        IProductEvaluationMetadata metadata = repository.findProductMetadata(skuCode);
        return evaluation(metadata, domain(data));
    }
}
