package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.gateway.GetAllBrandsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllBrandsUseCase {

    private final GetAllBrandsGateway getAllBrandsGateway;

    public List<BrandDomain> execute() {
        return getAllBrandsGateway.execute();
    }
}
