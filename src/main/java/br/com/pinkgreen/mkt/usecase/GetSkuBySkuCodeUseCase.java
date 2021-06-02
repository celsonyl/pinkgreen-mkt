package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.domain.exception.ObjectNotFoundException;
import br.com.pinkgreen.mkt.gateway.postgresql.GetSkuBySkuCodeImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetSkuBySkuCodeUseCase {

    private final GetSkuBySkuCodeImpl getSkuBySkuCode;

    public SkuDomain getSkuBySkuCode(String code) {
        return getSkuBySkuCode.getSkuBySkuCode(code)
                .orElseThrow(() -> new ObjectNotFoundException("Sku não encontrado: " + code));
    }
}
