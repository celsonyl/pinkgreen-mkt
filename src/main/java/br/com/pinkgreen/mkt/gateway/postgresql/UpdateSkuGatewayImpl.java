package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.UpdateSkuGateway;
import br.com.pinkgreen.mkt.translator.SkuProductMapper;
import br.com.pinkgreen.mkt.translator.SkuProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateSkuGatewayImpl implements UpdateSkuGateway {

    private final SkuRepository skuRepository;

    @Override
    public SkuDomain updateSku(SkuDomain skuDomain) {
        SkuProductMapper skuMapper = new SkuProductMapperImpl();

        var convert = skuMapper.skuDomainToDatabase(skuDomain);
        var skuDatabase = skuRepository.save(convert);

        return skuMapper.skuDatabaseToDomain(skuDatabase);
    }
}
