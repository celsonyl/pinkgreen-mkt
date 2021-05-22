package br.com.pinkgreen.mkt.controller.translator;

import br.com.pinkgreen.mkt.controller.model.CategoryRequest;
import br.com.pinkgreen.mkt.domain.CategoryDomain;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryRequestMapper {

    CategoryDomain categoryRequestToDomain(CategoryRequest categoryRequest);

    CategoryRequest categoryDomainToRequest(CategoryDomain categoryDomain);

}
