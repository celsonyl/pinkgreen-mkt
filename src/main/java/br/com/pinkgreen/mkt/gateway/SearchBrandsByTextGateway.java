package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.BrandDomain;

import java.util.List;

public interface SearchBrandsByTextGateway {

    List<BrandDomain> searchBrand(String text);

}
