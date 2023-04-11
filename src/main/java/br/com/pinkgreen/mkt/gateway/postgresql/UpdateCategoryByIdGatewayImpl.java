package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.domain.exception.ObjectNotFoundException;
import br.com.pinkgreen.mkt.gateway.UpdateCategoryByIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.CategoryDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCategoryByIdGatewayImpl implements UpdateCategoryByIdGateway {

    private final CategoryRepository repository;

    @Override
    public void execute(Integer id, CategoryDomain updatedCategory) {
        CategoryDatabase category = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada: " + id));

        fillValues(category, updatedCategory);

        repository.save(category);
    }

    private void fillValues(CategoryDatabase category, CategoryDomain updatedCategory) {
        if (updatedCategory.getName() != null) category.setName(updatedCategory.getName());
        if (updatedCategory.getImage() != null) category.setImage(updatedCategory.getImage());
    }
}
