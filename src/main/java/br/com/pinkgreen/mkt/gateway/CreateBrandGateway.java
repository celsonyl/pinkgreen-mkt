package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.BrandDomain;

public interface CreateBrandGateway {

    BrandDomain execute(BrandDomain brandDomain);
}
