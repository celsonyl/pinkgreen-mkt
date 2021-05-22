package br.com.pinkgreen.mkt.gateway.postgresql.translator;

import br.com.pinkgreen.mkt.domain.ProductCategoryDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductCategoryDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface ProductCategoryDatabaseMapper {

    ProductCategoryDomain categoryDatabaseToDomain(ProductCategoryDatabase productCategoryDatabase);

    ProductCategoryDatabase categoryDomainToDatabase(ProductCategoryDomain productCategoryDomain);

}
