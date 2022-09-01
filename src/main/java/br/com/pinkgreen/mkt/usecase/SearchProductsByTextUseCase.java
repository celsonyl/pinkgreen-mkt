package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.SearchProductsByTextGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchProductsByTextUseCase {

    private final SearchProductsByTextGateway searchProductsByTextGateway;

    public List<ProductDomain> searchProduct(String text) {
        return searchProductsByTextGateway.searchProduct(text);
    }
}