package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.ProductCategoryDomain;

public interface CreateProductCategoryGateway {

    ProductCategoryDomain execute(ProductCategoryDomain productCategoryDomain);
}
