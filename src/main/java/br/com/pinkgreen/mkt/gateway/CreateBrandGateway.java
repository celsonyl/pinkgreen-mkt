package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;

public interface CreateBrandGateway {

    BrandDomain execute(BrandDomain brandDomain) throws DataIntegrityException;
}
