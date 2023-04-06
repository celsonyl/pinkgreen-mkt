package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.gateway.DeleteProductByIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteProductByIdGatewayImpl implements DeleteProductByIdGateway {

    private final ProductRepository repository;

    @Override
    public void execute(Integer id) {
        repository.deleteById(id);
    }
}
