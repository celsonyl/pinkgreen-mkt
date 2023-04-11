package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.CategoryDomain;

public interface UpdateCategoryByIdGateway {
    void execute(Integer id, CategoryDomain category);
}
