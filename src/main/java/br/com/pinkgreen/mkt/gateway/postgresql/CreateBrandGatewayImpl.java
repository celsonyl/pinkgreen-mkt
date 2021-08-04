package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.gateway.CreateBrandGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.BrandRepository;
import br.com.pinkgreen.mkt.translator.BrandMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateBrandGatewayImpl implements CreateBrandGateway {

    private final BrandRepository brandRepository;

    @Override
    public BrandDomain execute(BrandDomain brandDomain) throws DataIntegrityException {
        var brandDatabaseMapper = new BrandMapperImpl();

        try {
            var brandDatabase = brandRepository.save(brandDatabaseMapper.brandDomainToDatabase(brandDomain));
            return brandDatabaseMapper.brandDatabaseToDomain(brandDatabase);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Já possui uma marca com esse nome cadastrada!");
        }
    }
}
