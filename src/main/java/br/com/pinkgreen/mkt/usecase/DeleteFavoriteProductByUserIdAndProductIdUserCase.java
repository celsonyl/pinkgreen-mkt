package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.gateway.DeleteFavoriteProductByUserIdAndProductIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteFavoriteProductByUserIdAndProductIdUserCase {

    @Autowired
    private final DeleteFavoriteProductByUserIdAndProductIdGateway deleteFavoriteProductByUserIdAndProductIdGateway;

    public void execute(String userId, String skuCode) {
        deleteFavoriteProductByUserIdAndProductIdGateway.execute(userId, skuCode);
    }

}
