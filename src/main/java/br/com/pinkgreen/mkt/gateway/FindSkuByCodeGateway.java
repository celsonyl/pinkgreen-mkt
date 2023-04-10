package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.SkuDomain;

import java.util.Optional;

public interface FindSkuByCodeGateway {
    Optional<SkuDomain> execute(String code);
}
