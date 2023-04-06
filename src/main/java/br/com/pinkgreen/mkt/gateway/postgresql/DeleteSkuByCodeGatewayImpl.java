package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.gateway.DeleteSkuByCodeGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.SkuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteSkuByCodeGatewayImpl implements DeleteSkuByCodeGateway {

    private final SkuRepository repository;

    @Override
    public void execute(String code) {
        repository.findSkuByCode(code).ifPresent(repository::delete);
    }
}
