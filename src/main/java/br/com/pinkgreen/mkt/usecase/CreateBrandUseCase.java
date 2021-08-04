package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.gateway.CreateBrandGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateBrandUseCase {

    private final CreateBrandGateway createBrandGateway;

    public BrandDomain execute(BrandDomain brandDomain) throws DataIntegrityException {
        return createBrandGateway.execute(brandDomain);
    }
}
