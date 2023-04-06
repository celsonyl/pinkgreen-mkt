package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.GetEnabledSkuBySkuCodeGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.SkuRepository;
import br.com.pinkgreen.mkt.translator.SkuProductMapper;
import br.com.pinkgreen.mkt.translator.SkuProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetEnabledSkuBySkuCodeGatewayImpl implements GetEnabledSkuBySkuCodeGateway {

    private final SkuRepository skuRepository;

    @Override
    public Optional<SkuDomain> getSkuBySkuCode(String code) {
        SkuProductMapper skuMapper = new SkuProductMapperImpl();
        return skuRepository.findActiveSkuByCode(code)
                .map(skuMapper::skuDatabaseToDomain);
    }
}
