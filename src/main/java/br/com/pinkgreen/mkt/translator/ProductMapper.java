package br.com.pinkgreen.mkt.translator;

import br.com.pinkgreen.mkt.controller.model.ProductRequest;
import br.com.pinkgreen.mkt.controller.model.ProductResponse;
import br.com.pinkgreen.mkt.domain.ProductDomain;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    ProductDomain productRequestToDomain(ProductRequest productRequest);

    ProductResponse productDomainToResponse(ProductDomain productDomain);
}
