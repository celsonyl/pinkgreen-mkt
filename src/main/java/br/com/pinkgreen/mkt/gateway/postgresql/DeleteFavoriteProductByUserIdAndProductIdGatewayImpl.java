package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.gateway.DeleteFavoriteProductByUserIdAndProductIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.FavoriteProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class DeleteFavoriteProductByUserIdAndProductIdGatewayImpl implements DeleteFavoriteProductByUserIdAndProductIdGateway {

    private final FavoriteProductRepository favoriteProductRepository;

    @Transactional
    @Override
    public void execute(String userId, String skuCode) {
        favoriteProductRepository.deleteByCustomerIdAndSkuCode(userId, skuCode);
    }
}
