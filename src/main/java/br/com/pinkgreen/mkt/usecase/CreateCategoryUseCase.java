package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.gateway.CreateCategoryGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateCategoryUseCase {

    private final CreateCategoryGateway createCategoryGateway;

    public CategoryDomain execute(CategoryDomain categoryDomain) throws DataIntegrityException {
        return createCategoryGateway.execute(categoryDomain);
    }


}
