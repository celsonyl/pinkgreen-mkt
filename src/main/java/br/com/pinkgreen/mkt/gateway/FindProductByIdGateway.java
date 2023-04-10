package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.ProductDomain;

import java.util.Optional;

public interface FindProductByIdGateway {
    Optional<ProductDomain> execute(Integer id);
}
