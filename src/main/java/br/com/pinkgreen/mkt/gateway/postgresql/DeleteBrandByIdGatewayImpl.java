package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.gateway.DeleteBrandByIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteBrandByIdGatewayImpl implements DeleteBrandByIdGateway {

    private final BrandRepository repository;

    @Override
    public void execute(Integer id) {
        repository.deleteById(id);
    }
}
