package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.GetMostSelledProductsGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.SkuRepository;
import br.com.pinkgreen.mkt.translator.SkuProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class GetMostSelledProductsGatewayImpl implements GetMostSelledProductsGateway {

    private final SkuRepository repository;

    @Override
    public List<SkuDomain> execute() {
        return repository.findMostSelled().stream().map(new SkuProductMapperImpl()::skuDatabaseToDomain)
                .collect(toList());
    }
}
