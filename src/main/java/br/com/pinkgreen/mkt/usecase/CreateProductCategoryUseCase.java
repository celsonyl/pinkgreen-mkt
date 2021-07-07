package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.gateway.CreateProductCategoryGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProductCategoryUseCase {

    private final CreateProductCategoryGateway createProductCategoryGateway;

    public CategoryDomain execute(CategoryDomain categoryDomain) throws DataIntegrityException {
        return createProductCategoryGateway.execute(categoryDomain);
    }


}
