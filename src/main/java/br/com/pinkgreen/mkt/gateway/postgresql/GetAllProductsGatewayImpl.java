package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetAllProductsGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.translator.ProductDomainToDatabase;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetAllProductsGatewayImpl implements GetAllProductsGateway {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDomain> execute() {
        var productDatabases = productRepository.findAll();
        return productDatabases.stream()
                .map(new ProductDomainToDatabase()::productDatabaseToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDomain> searchProduct(String text) {
        List<ProductDatabase> searchProducts = productRepository.findByNameContainsIgnoreCase(text);
        return searchProducts.stream()
                .map(new ProductMapperImpl()::productDatabaseToDomain)
                .collect(Collectors.toList());
    }
}
