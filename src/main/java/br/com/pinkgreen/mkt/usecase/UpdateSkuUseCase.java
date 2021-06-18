package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.UpdateSkuGatewayImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateSkuUseCase {

    private final UpdateSkuGatewayImpl updateSkuGateway;
    private final GetSkuBySkuCodeUseCase getSkuBySkuCodeUseCase;

    public SkuDomain updateSku(String code, SkuDomain skuUpdate) {
        SkuDomain skuDB = getSkuBySkuCodeUseCase.getSkuBySkuCode(code);

        update(skuUpdate, skuDB);

        return updateSkuGateway.updateSku(skuDB);
    }

    private void update(SkuDomain skuUpdate, SkuDomain skuDB) {
        if (skuUpdate.getName() != null) {
            skuDB.setName(skuUpdate.getName());
        }

        if (skuUpdate.getHeight() != null) {
            skuDB.setHeight(skuUpdate.getHeight());
        }

        if (skuUpdate.getWidth() != null) {
            skuDB.setWidth(skuUpdate.getWidth());
        }

        if (skuUpdate.getLength() != null) {
            skuDB.setLength(skuUpdate.getLength());
        }

        if (skuUpdate.getWeight() != null) {
            skuDB.setWeight(skuUpdate.getWeight());
        }

        if (skuUpdate.getMainImageUrl() != null) {
            skuDB.setMainImageUrl(skuUpdate.getMainImageUrl());
        }

        if (skuUpdate.getUrlImages() != null) {
            skuDB.setUrlImages(skuUpdate.getUrlImages());
        }

        if (skuUpdate.getPrice() != null) {
            skuDB.setPrice(skuUpdate.getPrice());
        }

        if (skuUpdate.getSkuAttributes() != null) {
            skuDB.setSkuAttributes(skuUpdate.getSkuAttributes());
        }
    }
}