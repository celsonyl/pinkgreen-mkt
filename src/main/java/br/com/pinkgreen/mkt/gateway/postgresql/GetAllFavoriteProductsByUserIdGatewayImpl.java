package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetAllFavoriteProductsByUserIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductRepository;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetAllFavoriteProductsByUserIdGatewayImpl implements GetAllFavoriteProductsByUserIdGateway {

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public List<ProductDomain> execute(String id) {
        var productMapper = new ProductMapperImpl();

        return productRepository.getAllByUserId(id)
                .stream()
                .map(productMapper::productDatabaseToDomain)
                .collect(Collectors.toList());
    }
}
