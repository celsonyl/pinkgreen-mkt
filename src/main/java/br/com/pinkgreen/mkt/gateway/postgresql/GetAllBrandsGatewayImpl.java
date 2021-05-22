package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.gateway.GetAllBrandsGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.BrandDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.translator.BrandDatabaseMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetAllBrandsGatewayImpl implements GetAllBrandsGateway {

    private final BrandRepository brandRepository;

    @Override
    public List<BrandDomain> execute() {
        List<BrandDatabase> brandDatabases = brandRepository.findAll();
        return brandDatabases.stream()
                .map(new BrandDatabaseMapperImpl()::brandDatabaseToDomain)
                .collect(Collectors.toList());
    }
}
