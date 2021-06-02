package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.UpdateProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateProductUseCase {

    private final GetProductByIdUseCase getProductByIdUseCase;
    private final UpdateProductGateway updateProductGateway;

    public ProductDomain updateProduct(Integer id, ProductDomain productUpdate) {
        ProductDomain productDB = getProductByIdUseCase.findById(id);

        populateProductDB(productUpdate, productDB);

        return updateProductGateway.updateProduct(productDB);
    }

    private void populateProductDB(ProductDomain productUpdate, ProductDomain productDB) {
        if (productUpdate.getName() != null) {
            productDB.setName(productUpdate.getName());
        }

        if (productUpdate.getPrice() != null) {
            productDB.setPrice(productUpdate.getPrice());
        }

        if (productUpdate.getActive() != null) {
            productDB.setActive(productUpdate.getActive());
        }
    }
}
