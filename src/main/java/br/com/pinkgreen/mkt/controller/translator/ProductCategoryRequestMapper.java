package br.com.pinkgreen.mkt.controller.translator;

import br.com.pinkgreen.mkt.controller.model.CategoryRequest;
import br.com.pinkgreen.mkt.domain.ProductCategoryDomain;
import org.mapstruct.Mapper;

@Mapper
public interface ProductCategoryRequestMapper {

    ProductCategoryDomain categoryRequestToDomain(CategoryRequest categoryRequest);

    CategoryRequest categoryDomainToRequest(ProductCategoryDomain productCategoryDomain);

}
