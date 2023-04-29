package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetProductAccessHistoricalByCustomerIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.CustomerAccessHistoricalDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.CustomerAccessHistoricalRepository;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.Long.compare;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class GetProductAccessHistoricalByCustomerIdGatewayImpl implements GetProductAccessHistoricalByCustomerIdGateway {

    private final CustomerAccessHistoricalRepository repository;

    @Override
    public List<ProductDomain> execute(String customerId) {
        return repository.findAllByCustomerId(customerId).stream()
                .sorted((a, b) -> compare(b.getLastAccess().toEpochMilli(), a.getLastAccess().toEpochMilli()))
                .map(CustomerAccessHistoricalDatabase::getProduct)
                .map(new ProductMapperImpl()::productDatabaseToDomain)
                .collect(toList());
    }
}
