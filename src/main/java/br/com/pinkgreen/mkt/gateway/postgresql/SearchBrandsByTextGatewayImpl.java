package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.gateway.SearchBrandsByTextGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.BrandDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.BrandRepository;
import br.com.pinkgreen.mkt.translator.BrandMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SearchBrandsByTextGatewayImpl implements SearchBrandsByTextGateway {

    private final BrandRepository brandRepository;

    @Override
    public List<BrandDomain> searchBrand(String text) {
        List<BrandDatabase> searchBrands = brandRepository.findByNameStartingWithIgnoreCase(text);
        return searchBrands.stream()
                .map(new BrandMapperImpl()::brandDatabaseToDomain)
                .collect(Collectors.toList());
    }
}
