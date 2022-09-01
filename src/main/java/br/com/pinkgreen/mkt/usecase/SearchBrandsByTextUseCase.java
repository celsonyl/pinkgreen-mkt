package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.SearchBrandsByTextGatewayImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchBrandsByTextUseCase {

    private final SearchBrandsByTextGatewayImpl searchBrandsByTextGateway;

    public List<BrandDomain> searchBrand(String text) {
        return searchBrandsByTextGateway.searchBrand(text);
    }
}
