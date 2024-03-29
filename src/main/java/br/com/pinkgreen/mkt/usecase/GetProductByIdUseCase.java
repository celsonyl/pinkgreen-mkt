package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.domain.exception.ObjectNotFoundException;
import br.com.pinkgreen.mkt.gateway.GetEnabledProductByIdGateway;
import br.com.pinkgreen.mkt.gateway.GetProductByIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetProductByIdUseCase {

    private final GetProductByIdGateway getProductByIdGateway;

    public ProductDomain findById(Integer id) {
        return getProductByIdGateway.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado: " + id));
    }
}
