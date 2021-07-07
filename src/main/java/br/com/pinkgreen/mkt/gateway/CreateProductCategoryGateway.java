package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;

public interface CreateProductCategoryGateway {

    CategoryDomain execute(CategoryDomain categoryDomain) throws DataIntegrityException;
}
