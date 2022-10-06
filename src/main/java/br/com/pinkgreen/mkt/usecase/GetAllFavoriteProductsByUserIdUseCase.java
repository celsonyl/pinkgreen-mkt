package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetAllFavoriteProductsByUserIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllFavoriteProductsByUserIdUseCase {

    @Autowired
    private final GetAllFavoriteProductsByUserIdGateway getAllFavoriteProductsByUserIdGateway;

    public List<ProductDomain> execute(String id) {
        return getAllFavoriteProductsByUserIdGateway.execute(id);
    }
}
