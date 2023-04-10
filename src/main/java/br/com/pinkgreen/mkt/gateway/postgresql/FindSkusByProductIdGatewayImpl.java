package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.FindSkusByProductIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.SkuRepository;
import br.com.pinkgreen.mkt.translator.SkuProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class FindSkusByProductIdGatewayImpl implements FindSkusByProductIdGateway {

    private final SkuRepository repository;

    @Override
    public List<SkuDomain> execute(Integer id) {
        return repository.findAllSkuByProductId(id).stream()
                .map(it -> new SkuProductMapperImpl().skuDatabaseToDomain(it))
                .collect(toList());
    }
}
