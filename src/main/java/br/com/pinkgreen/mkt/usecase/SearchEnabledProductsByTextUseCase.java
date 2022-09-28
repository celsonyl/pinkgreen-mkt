package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.SearchEnabledProductsByTextGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchEnabledProductsByTextUseCase {

    private final SearchEnabledProductsByTextGateway searchEnabledProductsByTextGateway;

    public List<ProductDomain> searchProduct(String text) {
        return searchEnabledProductsByTextGateway.searchProduct(text);
    }
}