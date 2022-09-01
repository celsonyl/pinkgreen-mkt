package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetAllProductsByBrandIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllProductsByBrandIdUseCase {

    private final GetAllProductsByBrandIdGateway getAllProductsByBrandGateway;

    public List<ProductDomain> execute(Integer id) {
        return getAllProductsByBrandGateway.execute(id);
    }
}