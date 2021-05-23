package br.com.pinkgreen.mkt.translator;

import br.com.pinkgreen.mkt.controller.model.CategoryRequest;
import br.com.pinkgreen.mkt.controller.model.CategoryResponse;
import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.model.CategoryDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    CategoryDomain categoryRequestToDomain(CategoryRequest categoryRequest);

    CategoryRequest categoryDomainToRequest(CategoryDomain categoryDomain);

    CategoryDomain categoryResponseToDomain(CategoryResponse categoryResponse);

    CategoryResponse categoryDomainToResponse(CategoryDomain categoryDomain);

    CategoryDomain categoryDatabaseToDomain(CategoryDatabase categoryDatabase);

    CategoryDatabase categoryDomainToDatabase(CategoryDomain categoryDomain);
}
