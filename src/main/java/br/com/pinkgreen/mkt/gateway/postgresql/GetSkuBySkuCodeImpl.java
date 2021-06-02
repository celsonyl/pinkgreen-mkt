package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.GetSkuBySkuCode;
import br.com.pinkgreen.mkt.gateway.postgresql.model.SkuDatabase;
import br.com.pinkgreen.mkt.translator.SkuProductMapper;
import br.com.pinkgreen.mkt.translator.SkuProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetSkuBySkuCodeImpl implements GetSkuBySkuCode {

    private final SkuRepository skuRepository;

    @Override
    public Optional<SkuDomain> getSkuBySkuCode(String code) {
        SkuProductMapper skuMapper = new SkuProductMapperImpl();
        Optional<SkuDatabase> skuDatabase = skuRepository.findSkuDatabaseByName(code);

        if (skuDatabase.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(skuMapper.skuDatabaseToDomain(skuDatabase.get()));
    }
}
