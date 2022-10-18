package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.GetAllFavoriteSkuProductsByUserIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllFavoriteProductsSkuByUserIdUseCase {

    @Autowired
    private final GetAllFavoriteSkuProductsByUserIdGateway getALlFavoriteSkuProductsByUserIdGateway;

    public List<SkuDomain> execute(String id) {
        return getALlFavoriteSkuProductsByUserIdGateway.execute(id);
    }
}
