package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.controller.model.CategoryRequest;

import java.util.List;

public interface GetAllCategoriesGateway {

    List<CategoryRequest> listCategories();
}
