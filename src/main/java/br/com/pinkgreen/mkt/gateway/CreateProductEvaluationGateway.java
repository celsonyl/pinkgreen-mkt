package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.ProductEvaluationDomain;

public interface CreateProductEvaluationGateway {

    ProductEvaluationDomain execute(ProductEvaluationDomain productEvaluationDomain);
}
