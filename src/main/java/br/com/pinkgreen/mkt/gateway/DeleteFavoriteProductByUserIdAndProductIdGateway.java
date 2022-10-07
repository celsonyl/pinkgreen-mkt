package br.com.pinkgreen.mkt.gateway;

public interface DeleteFavoriteProductByUserIdAndProductIdGateway {

    void execute(String userId, Integer productId);
}
