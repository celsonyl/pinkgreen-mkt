package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.gateway.postgresql.repository.SkuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class ReturnProductStockUseCase {

    private final SkuRepository skuRepository;

    @Transactional
    public void execute(Map<String, Integer> product) {
        product.forEach(skuRepository::appendStockQuantityBySkuCode);
    }
}
