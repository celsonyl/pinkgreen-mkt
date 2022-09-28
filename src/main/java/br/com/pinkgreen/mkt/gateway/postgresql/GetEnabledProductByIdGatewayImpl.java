package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetEnabledProductByIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.translator.ProductDomainToDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetEnabledProductByIdGatewayImpl implements GetEnabledProductByIdGateway {

    private final ProductRepository productRepository;

    @Override
    public Optional<ProductDomain> findById(Integer id) {
        var productMapper = new ProductDomainToDatabase();

        Optional<ProductDatabase> productDatabase = productRepository.findByIdAndActiveTrue(id);
        if (productDatabase.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(productMapper.productDatabaseToDomain(productDatabase.get()));
    }
}
