package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.FavoriteProductDomain;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;

public interface CreateFavoriteProductGateway {

    FavoriteProductDomain execute(FavoriteProductDomain favoriteProductDomain) throws DataIntegrityException;
}
