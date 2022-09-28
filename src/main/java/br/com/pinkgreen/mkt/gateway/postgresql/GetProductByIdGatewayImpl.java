package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetProductByIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.translator.ProductDomainToDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetProductByIdGatewayImpl implements GetProductByIdGateway {

    private final ProductRepository productRepository;

    @Override
    public Optional<ProductDomain> findById(Integer id) {
        var productMapper = new ProductDomainToDatabase();
        return productRepository.findById(id)
                .map(productMapper::productDatabaseToDomain);
    }
}
