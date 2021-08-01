package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductRepository;
import br.com.pinkgreen.mkt.translator.ProductMapper;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UpdateProductGatewayImpl implements br.com.pinkgreen.mkt.gateway.UpdateProductGateway {

    private final ProductRepository productRepository;

    @Override
    public ProductDomain updateProduct(ProductDomain productDomain) {
        ProductMapper productMapper = new ProductMapperImpl();
        var convert = productMapper.productDomainToDatabase(productDomain);

        ProductDatabase updateProduct = productRepository.save(convert);

        return productMapper.productDatabaseToDomain(updateProduct);
    }
}
