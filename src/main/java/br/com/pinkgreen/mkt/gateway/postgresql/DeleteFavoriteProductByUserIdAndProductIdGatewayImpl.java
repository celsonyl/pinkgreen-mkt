package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.gateway.DeleteFavoriteProductByUserIdAndProductIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.FavoriteProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteFavoriteProductByUserIdAndProductIdGatewayImpl implements DeleteFavoriteProductByUserIdAndProductIdGateway {

    private final FavoriteProductRepository favoriteProductRepository;

    @Override
    public void execute(String userId, Integer productId) {
        favoriteProductRepository.deleteByUserIdAndProductId(userId, productId);
    }
}
