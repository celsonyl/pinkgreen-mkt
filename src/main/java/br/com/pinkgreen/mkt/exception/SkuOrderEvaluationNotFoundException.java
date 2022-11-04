package br.com.pinkgreen.mkt.exception;

import java.util.function.Supplier;

import static java.lang.String.format;

public class SkuOrderEvaluationNotFoundException extends RuntimeException {
    public SkuOrderEvaluationNotFoundException(Integer orderId, String skuCode) {
        super(format("skuCode - '%s': Is not evaluated. orderId: '%s'", skuCode, orderId));
    }

    public static Supplier<SkuOrderEvaluationNotFoundException> evaluationNotFound(Integer orderId, String skuCode) {
        return () -> new SkuOrderEvaluationNotFoundException(orderId, skuCode);
    }
}
