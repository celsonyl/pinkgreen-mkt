package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetAllProductsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllProductsUseCase {

    private final GetAllProductsGateway getAllProductsGateway;

    public List<ProductDomain> execute() {
        return getAllProductsGateway.execute();
    }

    public List<ProductDomain> searchProduct(String text) {
        return getAllProductsGateway.searchProduct(text);
    }
}
