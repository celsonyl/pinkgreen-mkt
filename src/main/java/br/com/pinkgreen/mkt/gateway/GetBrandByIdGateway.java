package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.BrandDomain;

import java.util.Optional;

public interface GetBrandByIdGateway {

    Optional<BrandDomain> execute(Integer id);
}
