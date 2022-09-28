package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetAllEnabledProductsByBrandIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllEnabledProductsByBrandIdUseCase {

    private final GetAllEnabledProductsByBrandIdGateway getAllProductsByBrandGateway;

    public List<ProductDomain> execute(Integer id) {
        return getAllProductsByBrandGateway.execute(id);
    }
}