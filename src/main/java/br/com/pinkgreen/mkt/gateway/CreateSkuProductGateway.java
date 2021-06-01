package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.SkuDomain;

public interface CreateSkuProductGateway {

    SkuDomain execute(SkuDomain skuDomain);
}
