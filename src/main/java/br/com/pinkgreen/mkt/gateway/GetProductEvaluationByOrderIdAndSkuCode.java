package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.ProductEvaluationDomain;

import java.util.Optional;

public interface GetProductEvaluationByOrderIdAndSkuCode {
    Optional<ProductEvaluationDomain> execute(Integer orderId, String skuCode);
}
