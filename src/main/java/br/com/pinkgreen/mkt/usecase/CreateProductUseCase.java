package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.CreateProductGatewayImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CreateProductUseCase {

    private final CreateProductGatewayImpl createProductGateway;

    public ProductDomain execute(ProductDomain productDomain) {
        return createProductGateway.execute(productDomain);
    }

}
