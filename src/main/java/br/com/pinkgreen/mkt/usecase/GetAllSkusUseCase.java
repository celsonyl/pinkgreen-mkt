package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.GetAllSkusGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllSkusUseCase {

    private final GetAllSkusGateway getAllSkusGateway;

    public List<SkuDomain> execute() {
        return getAllSkusGateway.execute();
    }
}
