package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.ProductEvaluationDomain;

import java.util.List;

public interface GetProductEvaluationByOrderId {
    List<ProductEvaluationDomain> execute(Integer orderId);
}
