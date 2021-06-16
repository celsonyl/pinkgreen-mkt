package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.BrandDomain;

import java.util.List;

public interface GetAllBrandsGateway {

    List<BrandDomain> execute();

    List<BrandDomain> searchBrand(String text);
}
