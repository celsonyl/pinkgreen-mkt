package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.gateway.RegisterCustomerProductAccessGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.CustomerAccessHistoricalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class RegisterCustomerProductAccessGatewayImpl implements RegisterCustomerProductAccessGateway {

    private final CustomerAccessHistoricalRepository repository;

    @Transactional
    @Override
    public void execute(String customerId, Integer productId) {
        repository.upsertAccessHistory(customerId, productId);
    }
}
