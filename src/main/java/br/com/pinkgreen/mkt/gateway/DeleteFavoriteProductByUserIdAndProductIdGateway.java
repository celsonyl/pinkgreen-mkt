package br.com.pinkgreen.mkt.gateway;

public interface DeleteFavoriteProductByUserIdAndProductIdGateway {

    void execute(String userId, String skuCode);
}
