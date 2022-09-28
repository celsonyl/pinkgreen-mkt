package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.exception.ObjectNotFoundException;
import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetEnabledProductByIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetEnabledProductByIdUseCase {

    private final GetEnabledProductByIdGateway getEnabledProductByIdGateway;

    public ProductDomain findById(Integer id) {
        return getEnabledProductByIdGateway.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado: " + id));
    }
}
