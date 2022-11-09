package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.ProductEvaluationBySkuCode;

public interface GetProductEvaluationBySkuCode {
    ProductEvaluationBySkuCode execute(String skuCode);
}
