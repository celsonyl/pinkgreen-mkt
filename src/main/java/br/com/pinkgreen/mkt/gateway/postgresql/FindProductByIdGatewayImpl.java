package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.FindProductByIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductRepository;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindProductByIdGatewayImpl implements FindProductByIdGateway {

    private final ProductRepository repository;

    @Override
    public Optional<ProductDomain> execute(Integer id) {
        return repository.findById(id).map(it -> new ProductMapperImpl().productDatabaseToDomain(it));
    }
}
