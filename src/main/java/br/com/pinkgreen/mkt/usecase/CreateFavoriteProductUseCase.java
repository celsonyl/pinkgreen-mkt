package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.FavoriteProductDomain;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.gateway.CreateFavoriteProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateFavoriteProductUseCase {

    private final CreateFavoriteProductGateway createFavoriteProductGateway;

    public FavoriteProductDomain execute(FavoriteProductDomain favoriteProductDomain) throws DataIntegrityException {
        return createFavoriteProductGateway.execute(favoriteProductDomain);
    }
}
