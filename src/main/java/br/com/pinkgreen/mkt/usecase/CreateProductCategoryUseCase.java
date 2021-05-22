package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.ProductCategoryDomain;
import br.com.pinkgreen.mkt.gateway.CreateProductCategoryGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProductCategoryUseCase {

    private final CreateProductCategoryGateway createProductCategoryGateway;

    public ProductCategoryDomain execute(ProductCategoryDomain productCategoryDomain) {
        return createProductCategoryGateway.execute(productCategoryDomain);
    }


}
