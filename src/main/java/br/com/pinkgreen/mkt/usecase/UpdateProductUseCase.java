package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.UpdateProductGatewayImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateProductUseCase {

    private final UpdateProductGatewayImpl updateProductGateway;

    public ProductDomain updateProduct(ProductDomain productDomain) {
        return updateProductGateway.updateProduct(productDomain);
    }
}
