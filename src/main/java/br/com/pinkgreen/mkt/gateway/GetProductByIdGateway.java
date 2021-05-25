package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.domain.ProductOrderDomain;

import java.util.Optional;

public interface GetProductByIdGateway {

    Optional<ProductDomain> findById(Integer id);
}
