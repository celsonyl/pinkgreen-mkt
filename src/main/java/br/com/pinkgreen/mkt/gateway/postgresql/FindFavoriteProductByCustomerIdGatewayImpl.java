package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.FavoriteProductDomain;
import br.com.pinkgreen.mkt.gateway.FindFavoriteProductByCustomerIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.FavoriteProductDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.FavoriteProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class FindFavoriteProductByCustomerIdGatewayImpl implements FindFavoriteProductByCustomerIdGateway {

    private final FavoriteProductRepository repository;

    public FindFavoriteProductByCustomerIdGatewayImpl(FavoriteProductRepository repository) {this.repository = repository;}

    @Override
    public Optional<FavoriteProductDomain> execute(String customerId, String skuCode) {
        return ofNullable(repository.findByCustomerIdAndSkuCode(
                customerId,
                skuCode
        )).map(FavoriteProductDatabase::domain);
    }
}
