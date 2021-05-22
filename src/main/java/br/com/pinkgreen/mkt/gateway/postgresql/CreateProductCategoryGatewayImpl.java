package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductCategoryDomain;
import br.com.pinkgreen.mkt.gateway.CreateProductCategoryGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductCategoryDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.translator.ProductCategoryDatabaseMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProductCategoryGatewayImpl implements CreateProductCategoryGateway {

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategoryDomain execute(ProductCategoryDomain productCategoryDomain) {
        ProductCategoryDatabaseMapperImpl categoryDatabaseMapper = new ProductCategoryDatabaseMapperImpl();

        ProductCategoryDatabase productCategoryDatabase = categoryDatabaseMapper.categoryDomainToDatabase(productCategoryDomain);
        return categoryDatabaseMapper.categoryDatabaseToDomain(productCategoryRepository.save(productCategoryDatabase));
    }
}
