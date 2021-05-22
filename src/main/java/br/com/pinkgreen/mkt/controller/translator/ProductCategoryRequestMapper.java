package br.com.pinkgreen.mkt.controller.translator;

import br.com.pinkgreen.mkt.controller.model.ProductCategoryRequest;
import br.com.pinkgreen.mkt.domain.ProductCategoryDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductCategoryDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface ProductCategoryRequestMapper {

    ProductCategoryDomain categoryRequestToDomain(ProductCategoryRequest productCategoryRequest);

    ProductCategoryRequest categoryDomainToRequest(ProductCategoryDomain productCategoryDomain);

}
