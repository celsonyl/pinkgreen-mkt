package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetProductByIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductDatabase;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetProductByIdGatewayImpl implements GetProductByIdGateway {

    private final ProductRepository productRepository;

    @Override
    public Optional<ProductDomain> findById(Integer id) {
        var productMapper = new ProductMapperImpl();

        Optional<ProductDatabase> productDatabase = productRepository.findById(id);
        if (productDatabase.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(productMapper.productDatabaseToDomain(productDatabase.get()));
    }
}
