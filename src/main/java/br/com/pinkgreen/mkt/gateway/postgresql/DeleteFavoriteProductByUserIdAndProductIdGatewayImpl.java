package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.gateway.DeleteFavoriteProductByUserIdAndProductIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteFavoriteProductByUserIdAndProductIdGatewayImpl implements DeleteFavoriteProductByUserIdAndProductIdGateway {

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public void execute(String userId, Integer productId) {
        productRepository.deleteFavoriteProduct(userId, productId);
    }
}
