package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetAllEnabledProductsByBrandIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductRepository;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetAllEnabledProductsByBrandIdGatewayImpl implements GetAllEnabledProductsByBrandIdGateway {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDomain> execute(Integer id) {
        var productMapper = new ProductMapperImpl();

        List<ProductDatabase> listProducts = productRepository.findAllByBrandIdAndActiveTrue(id);
        return listProducts.stream()
                .map(productMapper::productDatabaseToDomain)
                .collect(Collectors.toList());
    }
}