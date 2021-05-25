package br.com.pinkgreen.mkt.translator;

import br.com.pinkgreen.mkt.controller.model.ProductRequest;
import br.com.pinkgreen.mkt.controller.model.ProductResponse;
import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDomain productDatabaseToDomain(ProductDatabase productDatabase);

    ProductDatabase productDomainToDatabase(ProductDomain productDomain);

    ProductResponse productDomainToResponse(ProductDomain productDomain);

    ProductDomain productRequestToDomain(ProductRequest productRequest);
}
