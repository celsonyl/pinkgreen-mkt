package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.ProductDomain;

import java.util.List;

public interface GetAllFavoriteProductsByUserIdGateway {

    List<ProductDomain> execute(String id);
}
