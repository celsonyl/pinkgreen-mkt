package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.ProductDomain;

import java.util.List;

public interface GetAllProductsGateway {

    List<ProductDomain> execute();

    List<ProductDomain> searchProduct(String text);
}
