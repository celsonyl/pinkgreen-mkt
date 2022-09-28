package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.SearchEnabledProductsByTextGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductRepository;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SearchEnabledProductsByTextGatewayImpl implements SearchEnabledProductsByTextGateway {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDomain> searchProduct(String text) {
        List<ProductDatabase> searchProducts = productRepository.findByNameContainsIgnoreCaseAndActiveTrue(text);
        return searchProducts.stream()
                .filter(ProductDatabase::getActive)
                .map(new ProductMapperImpl()::productDatabaseToDomain)
                .collect(Collectors.toList());
    }
}