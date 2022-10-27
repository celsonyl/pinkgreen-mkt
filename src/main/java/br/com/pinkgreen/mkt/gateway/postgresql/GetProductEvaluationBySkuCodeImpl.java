package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductEvaluationDomain;
import br.com.pinkgreen.mkt.gateway.GetProductEvaluationBySkuCode;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductEvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.pinkgreen.mkt.gateway.postgresql.model.ProductEvaluationDatabase.domain;

@Service
@RequiredArgsConstructor
public class GetProductEvaluationBySkuCodeImpl implements GetProductEvaluationBySkuCode {

    private final ProductEvaluationRepository repository;

    @Override
    public List<ProductEvaluationDomain> execute(String skuCode) {
        return domain(repository.findAllBySkuCode(skuCode));
    }
}
