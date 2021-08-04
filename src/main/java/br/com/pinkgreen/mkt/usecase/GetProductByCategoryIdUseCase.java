package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetProductByCategoryIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetProductByCategoryIdUseCase {

    private final GetProductByCategoryIdGateway getProductByCategoryIdGateway;

    public List<ProductDomain> execute(Integer id) {
        return getProductByCategoryIdGateway.execute(id);
    }
}
