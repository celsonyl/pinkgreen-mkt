package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.RelatedSkusDomain;
import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.domain.exception.ObjectNotFoundException;
import br.com.pinkgreen.mkt.gateway.GetEnabledSkuBySkuCodeGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetEnabledSkuBySkuCodeUseCase {

    private final GetEnabledSkuBySkuCodeGateway getSkuBySkuCode;
    private final GetAllEnabledSkusByProductIdUseCase getAllEnabledSkusByProductIdUseCase;

    public SkuDomain getSkuBySkuCode(String code) {
        var skuDomain = getSkuBySkuCode.getSkuBySkuCode(code)
                .orElseThrow(() -> new ObjectNotFoundException("Sku não encontrado: " + code));
        var relatedSkus = getAllEnabledSkusByProductIdUseCase.execute(skuDomain.getProduct().getId());
        skuDomain.setRelatedSkus(relatedSkus.stream()
                .filter(x -> !x.getSkuCode().equals(skuDomain.getSkuCode()))
                .map(GetEnabledSkuBySkuCodeUseCase::toRelated)
                .collect(Collectors.toList()));

        return skuDomain;
    }

    private static RelatedSkusDomain toRelated(SkuDomain skuDomain) {
        return RelatedSkusDomain.builder()
                .id(skuDomain.getId())
                .product(skuDomain.getProduct())
                .skuCode(skuDomain.getSkuCode())
                .name(skuDomain.getName())
                .mainImageUrl(skuDomain.getMainImageUrl())
                .price(skuDomain.getPrice())
                .build();
    }
}
