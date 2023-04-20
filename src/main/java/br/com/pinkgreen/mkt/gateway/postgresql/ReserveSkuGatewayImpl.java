package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductOrderDomain;
import br.com.pinkgreen.mkt.gateway.ReserveSkuGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.SkuDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.SkuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@Component
@RequiredArgsConstructor
public class ReserveSkuGatewayImpl implements ReserveSkuGateway {

    private final SkuRepository skuRepository;

    @Override
    public boolean execute(List<ProductOrderDomain> products) {
        var skus = products.parallelStream()
                .map(product -> skuRepository.findActiveSkuByCode(product.getSkuCode()).orElseThrow())
                .collect(toMap(SkuDatabase::getSkuCode, skuDatabase -> skuDatabase));

        if (!skus.values().stream().allMatch(it -> it.getStockQuantity() > 0)) return false;

        var skuStockUpdated = products.parallelStream().map(product -> {
            var sku = skus.get(product.getSkuCode());
            sku.setStockQuantity(sku.getStockQuantity() - product.getQuantity());
            return sku;
        }).collect(toList());

        skuRepository.saveAll(skuStockUpdated);
        return true;
    }
}
