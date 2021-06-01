package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.CreateSkuProductGateway;
import br.com.pinkgreen.mkt.translator.SkuProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateSkuProductGatewayImpl implements CreateSkuProductGateway {

    private final SkuRepository skuRepository;

    @Override
    public SkuDomain execute(SkuDomain skuDomain) {
        var skuMapper = new SkuProductMapperImpl();

        var skuDatabase = skuRepository.save(skuMapper.skuDomainToDatabase(skuDomain));
        return skuMapper.skuDatabaseToDomain(skuDatabase);
    }
}
