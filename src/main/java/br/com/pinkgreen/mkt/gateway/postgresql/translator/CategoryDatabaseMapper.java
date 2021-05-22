package br.com.pinkgreen.mkt.gateway.postgresql.translator;

import br.com.pinkgreen.mkt.domain.ProductCategoryDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.model.CategoryDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryDatabaseMapper {

    ProductCategoryDomain categoryDatabaseToDomain(CategoryDatabase categoryDatabase);

    CategoryDatabase categoryDomainToDatabase(ProductCategoryDomain productCategoryDomain);

}
