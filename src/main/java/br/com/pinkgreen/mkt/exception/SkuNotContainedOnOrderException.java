package br.com.pinkgreen.mkt.exception;

import static java.lang.String.format;

public class SkuNotContainedOnOrderException extends RuntimeException {
    public SkuNotContainedOnOrderException(String skuCode) {
        super(format("skuCode - '%s': Is not contained on order to be evaluated.", skuCode));
    }
}
