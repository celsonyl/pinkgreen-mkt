package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.gateway.CreateProductCategoryGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.CategoryDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.translator.CategoryDatabaseMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProductCategoryGatewayImpl implements CreateProductCategoryGateway {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDomain execute(CategoryDomain categoryDomain) {
        CategoryDatabaseMapperImpl categoryDatabaseMapper = new CategoryDatabaseMapperImpl();

        CategoryDatabase categoryDatabase = categoryDatabaseMapper.categoryDomainToDatabase(categoryDomain);
        return categoryDatabaseMapper.categoryDatabaseToDomain(categoryRepository.save(categoryDatabase));
    }
}
