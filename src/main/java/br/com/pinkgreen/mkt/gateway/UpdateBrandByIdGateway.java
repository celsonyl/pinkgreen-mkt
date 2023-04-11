package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.BrandDomain;

public interface UpdateBrandByIdGateway {
    void execute(Integer id, BrandDomain updatedBrand);
}
