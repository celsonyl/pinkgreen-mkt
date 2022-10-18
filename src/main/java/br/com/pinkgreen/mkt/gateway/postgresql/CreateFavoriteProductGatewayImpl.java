package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.FavoriteProductDomain;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.gateway.CreateFavoriteProductGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.FavoriteProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static br.com.pinkgreen.mkt.gateway.postgresql.model.FavoriteProductDatabase.database;

@Component
@RequiredArgsConstructor
public class CreateFavoriteProductGatewayImpl implements CreateFavoriteProductGateway {

    private final FavoriteProductRepository favoriteProductRepository;

    @Override
    public FavoriteProductDomain execute(FavoriteProductDomain favoriteProductDomain) throws DataIntegrityException {
        var favoriteProductOpt = Optional.ofNullable(favoriteProductRepository.findByCustomerIdAndSkuCode(
                favoriteProductDomain.getUserId(),
                favoriteProductDomain.getSkuCode())
        );

        if (favoriteProductOpt.isPresent()) throw new DataIntegrityException("PRODUTO FAVORITO JÁ ADICIONADO");

        return favoriteProductRepository.save(database(favoriteProductDomain)).domain();
    }
}
