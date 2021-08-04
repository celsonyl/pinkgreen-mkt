package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.gateway.CreateCategoryGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.CategoryRepository;
import br.com.pinkgreen.mkt.translator.CategoryMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateCategoryGatewayImpl implements CreateCategoryGateway {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDomain execute(CategoryDomain categoryDomain) throws DataIntegrityException {
        var categoryDatabaseMapper = new CategoryMapperImpl();

        try {
            var categoryDatabase = categoryDatabaseMapper.categoryDomainToDatabase(categoryDomain);
            return categoryDatabaseMapper.categoryDatabaseToDomain(categoryRepository.save(categoryDatabase));
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Já existe uma Categoria com esse nome");
        }
    }
}
