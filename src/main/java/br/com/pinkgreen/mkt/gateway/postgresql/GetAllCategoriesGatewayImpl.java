package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.gateway.GetAllCategoriesGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.CategoryDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.translator.CategoryDatabaseMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetAllCategoriesGatewayImpl implements GetAllCategoriesGateway {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDomain> listCategories() {
        List<CategoryDatabase> categoryDatabaseList = categoryRepository.findAll();
        return categoryDatabaseList.stream()
                .map(x -> new CategoryDatabaseMapperImpl().categoryDatabaseToDomain(x))
                .collect(Collectors.toList());
    }
}
