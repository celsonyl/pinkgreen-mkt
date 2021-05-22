package br.com.pinkgreen.mkt.controller.translator;

import br.com.pinkgreen.mkt.controller.model.CategoryResponse;
import br.com.pinkgreen.mkt.domain.CategoryDomain;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryResponseMapper {

    CategoryDomain categoryResponseToDomain(CategoryResponse categoryResponse);

    CategoryResponse categoryDomainToResponse(CategoryDomain categoryDomain);

}
