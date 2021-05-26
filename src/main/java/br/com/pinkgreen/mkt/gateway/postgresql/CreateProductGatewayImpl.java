package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.CreateProductGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.translator.ProductDomainToDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProductGatewayImpl implements CreateProductGateway {

    private final ProductRepository productRepository;

    @Override
    public ProductDomain execute(ProductDomain productDomain) {
        var productMapper = new ProductDomainToDatabase();

        var productDatabase = productRepository.save(productMapper.productDomainToDatabase(productDomain));
        return productMapper.productDatabaseToDomain(productDatabase);
    }
}
