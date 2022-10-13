package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.FavoriteProductDomain;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.gateway.CreateFavoriteProductGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.FavoriteProductRepository;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateFavoriteProductGatewayImpl implements CreateFavoriteProductGateway {

    private final FavoriteProductRepository favoriteProductRepository;

    @Override
    public FavoriteProductDomain execute(FavoriteProductDomain favoriteProductDomain) throws DataIntegrityException {
        var favoriteProductList = favoriteProductRepository
                .getFavoriteProductDatabaseByUserIdAndProductId(favoriteProductDomain.getUserId(), favoriteProductDomain.getProductId());

        if (!favoriteProductList.isEmpty()) {
            throw new DataIntegrityException("PRODUTO FAVORITO JÁ ADICIONADO");
        }

        return new ProductMapperImpl()
                .favoriteProductDatabaseToDomain(favoriteProductRepository.save(new ProductMapperImpl().favoriteProductDomainToDatabase(favoriteProductDomain)));
    }
}
