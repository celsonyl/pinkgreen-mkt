package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.exception.ObjectNotFoundException;
import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.gateway.GetBrandByIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetBrandByIdUseCase {

    private final GetBrandByIdGateway getBrandByIdGateway;

    public BrandDomain execute(Integer id) {
        return getBrandByIdGateway.execute(id)
                .orElseThrow(() -> new ObjectNotFoundException("Marca não encontrada: " + id));
    }
}
