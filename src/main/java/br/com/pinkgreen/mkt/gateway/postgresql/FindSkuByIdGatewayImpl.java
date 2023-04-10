package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.FindSkuByIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.SkuRepository;
import br.com.pinkgreen.mkt.translator.SkuProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindSkuByIdGatewayImpl implements FindSkuByIdGateway {

    private final SkuRepository repository;

    @Override
    public Optional<SkuDomain> execute(String code) {
        return repository.findSkuByCode(code)
                .map(it -> new SkuProductMapperImpl().skuDatabaseToDomain(it));
    }
}
