package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.CategoryDomain;

import java.util.List;

public interface GetAllCategoriesGateway {

    List<CategoryDomain> listCategories();
}
