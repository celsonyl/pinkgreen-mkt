package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.GetAllSkusByProductIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllSkusByProductIdUseCase {

    private final GetAllSkusByProductIdGateway getAllSkusByProductIdGateway;

    public List<SkuDomain> execute(Integer productId) {
        return getAllSkusByProductIdGateway.execute(productId);
    }
}
