package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.FavoriteProductDomain;

import java.util.Optional;

public interface FindFavoriteProductByCustomerIdGateway {
    Optional<FavoriteProductDomain> execute(String customerId, String skuCode);
}
