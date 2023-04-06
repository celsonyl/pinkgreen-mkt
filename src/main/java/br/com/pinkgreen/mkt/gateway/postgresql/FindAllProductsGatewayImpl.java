package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.controller.model.ProductResponse;
import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.FindAllProductsGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.translator.ProductDomainToDatabase;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class FindAllProductsGatewayImpl implements FindAllProductsGateway {

    private final ProductRepository repository;

    @Override
    public List<ProductDomain> execute() {
        return repository.findAll().stream()
                .map(it -> new ProductMapperImpl().productDatabaseToDomain(it))
                .collect(toList());
    }
}
