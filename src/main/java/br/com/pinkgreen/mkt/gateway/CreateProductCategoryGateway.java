package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.CategoryDomain;

public interface CreateProductCategoryGateway {

    CategoryDomain execute(CategoryDomain categoryDomain);
}
