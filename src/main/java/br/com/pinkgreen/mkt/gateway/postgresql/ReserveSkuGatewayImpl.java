package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.ProductOrderDomain;
import br.com.pinkgreen.mkt.gateway.ReserveSkuGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.SkuDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.SkuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReserveSkuGatewayImpl implements ReserveSkuGateway {

    private final SkuRepository skuRepository;

    @Override
    public boolean execute(List<ProductOrderDomain> products) {
        var skus = products.parallelStream()
                .map(product -> skuRepository.findActiveSkuByCode(product.getSkuCode()).orElseThrow())
                .collect(Collectors.toMap(SkuDatabase::getSkuCode, skuDatabase -> skuDatabase));

        var skuStockUpdated = products.parallelStream().map(product -> {
            var sku = skus.get(product.getSkuCode());
            sku.setStockQuantity(sku.getStockQuantity() - product.getQuantity());
            return sku;
        }).collect(Collectors.toList());

       var stockAvailable = skuStockUpdated.parallelStream().allMatch(product -> product.getStockQuantity() >= 0);

        if (stockAvailable) {
            skuRepository.saveAll(skuStockUpdated);
            return true;
        } else {
            return false;
        }
    }
}
