package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.gateway.CreateBrandGateway;
import br.com.pinkgreen.mkt.translator.BrandMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateBrandGatewayImpl implements CreateBrandGateway {

    private final BrandRepository brandRepository;

    @Override
    public BrandDomain execute(BrandDomain brandDomain) {
        var brandDatabaseMapper = new BrandMapperImpl();

        var brandDatabase = brandRepository.save(brandDatabaseMapper.brandDomainToDatabase(brandDomain));
        return brandDatabaseMapper.brandDatabaseToDomain(brandDatabase);
    }
}
