package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;

public interface CreateSkuProductGateway {

    SkuDomain execute(SkuDomain skuDomain) throws DataIntegrityException;
}
