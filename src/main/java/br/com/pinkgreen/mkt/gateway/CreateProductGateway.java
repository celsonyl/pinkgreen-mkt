package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.ProductDomain;

public interface CreateProductGateway {

    ProductDomain execute(ProductDomain productDomain);
}
