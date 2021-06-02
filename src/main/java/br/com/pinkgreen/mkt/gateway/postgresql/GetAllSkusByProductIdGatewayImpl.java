package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.GetAllSkusByProductIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.SkuDatabase;
import br.com.pinkgreen.mkt.translator.SkuProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetAllSkusByProductIdGatewayImpl implements GetAllSkusByProductIdGateway {

    private final SkuRepository skuRepository;

    @Override
    public List<SkuDomain> execute(Integer productId) {
        var skuMapper = new SkuProductMapperImpl();

        List<SkuDatabase> skuDatabases = skuRepository.findAllByProductId(productId);
        return skuDatabases.stream()
                .map(skuMapper::skuDatabaseToDomain)
                .collect(Collectors.toList());
    }
}
