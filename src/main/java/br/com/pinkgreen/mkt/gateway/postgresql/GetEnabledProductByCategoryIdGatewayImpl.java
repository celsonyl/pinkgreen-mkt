package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetEnabledProductByCategoryIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.translator.ProductDomainToDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetEnabledProductByCategoryIdGatewayImpl implements GetEnabledProductByCategoryIdGateway {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDomain> execute(Integer id) {
        var productDatabases = productRepository.findAllByCategoriesIdAndActiveTrue(id);
        return productDatabases.stream()
                .filter(ProductDatabase::getActive)
                .map(new ProductDomainToDatabase()::productDatabaseToDomain)
                .collect(Collectors.toList());
    }
}
