package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.CategoryDomain;

import java.util.Optional;

public interface GetCategoryByIdGateway {

    Optional<CategoryDomain> findById(Integer id);
}
