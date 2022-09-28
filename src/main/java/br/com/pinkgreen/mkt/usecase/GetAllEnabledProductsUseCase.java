package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetAllEnabledProductsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllEnabledProductsUseCase {

    private final GetAllEnabledProductsGateway getAllEnabledProductsGateway;

    public List<ProductDomain> execute() {
        return getAllEnabledProductsGateway.execute();
    }
}
