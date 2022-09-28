package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetEnabledProductByCategoryIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetEnabledProductByCategoryIdUseCase {

    private final GetEnabledProductByCategoryIdGateway getEnabledProductByCategoryIdGateway;

    public List<ProductDomain> execute(Integer id) {
        return getEnabledProductByCategoryIdGateway.execute(id);
    }
}
