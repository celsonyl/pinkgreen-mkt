package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.gateway.GetCategoryByIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.CategoryDatabase;
import br.com.pinkgreen.mkt.translator.CategoryMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetCaregoryByIdCatewayImpl implements GetCategoryByIdGateway {

    private final CategoryRepository categoryRepository;

    @Override
    public Optional<CategoryDomain> findById(Integer id) {
        var categoryDatabaseMapper = new CategoryMapperImpl();

        Optional<CategoryDatabase> categoryRequest = categoryRepository.findById(id);
        if (categoryRequest.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(categoryDatabaseMapper.categoryDatabaseToDomain(categoryRequest.get()));
    }
}
