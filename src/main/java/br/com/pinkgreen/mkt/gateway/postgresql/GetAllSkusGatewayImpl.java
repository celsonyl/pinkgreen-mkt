package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.GetAllSkusGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.SkuRepository;
import br.com.pinkgreen.mkt.translator.SkuProductMapper;
import br.com.pinkgreen.mkt.translator.SkuProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetAllSkusGatewayImpl implements GetAllSkusGateway {

    private final SkuRepository skuRepository;

    @Override
    public List<SkuDomain> execute() {
        SkuProductMapper skuProductMapper = new SkuProductMapperImpl();

        return skuRepository.findAll()
                .stream()
                .map(skuProductMapper::skuDatabaseToDomain)
                .collect(Collectors.toList());
    }
}
