package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.GetAllEnabledSkusByProductIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllEnabledSkusByProductIdUseCase {

    private final GetAllEnabledSkusByProductIdGateway getAllEnabledSkusByProductIdGateway;

    public List<SkuDomain> execute(Integer productId) {
        return getAllEnabledSkusByProductIdGateway.execute(productId);
    }
}
