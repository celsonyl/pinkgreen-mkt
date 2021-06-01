package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.CreateSkuProductGatewayImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateSkuProductUseCase {

    private final CreateSkuProductGatewayImpl createSkuProductGateway;

    public SkuDomain execute(SkuDomain skuDomain){
        return createSkuProductGateway.execute(skuDomain);
    }
}
