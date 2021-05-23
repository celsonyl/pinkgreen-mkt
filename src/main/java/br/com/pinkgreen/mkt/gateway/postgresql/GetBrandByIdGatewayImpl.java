package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.gateway.GetBrandByIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.BrandDatabase;
import br.com.pinkgreen.mkt.translator.BrandMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetBrandByIdGatewayImpl implements GetBrandByIdGateway {

    private final BrandRepository brandRepository;

    @Override
    public Optional<BrandDomain> execute(Integer id) {
        Optional<BrandDatabase> brandDatabase = brandRepository.findById(id);
        if (brandDatabase.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new BrandMapperImpl().brandDatabaseToDomain(brandDatabase.get()));
    }
}
