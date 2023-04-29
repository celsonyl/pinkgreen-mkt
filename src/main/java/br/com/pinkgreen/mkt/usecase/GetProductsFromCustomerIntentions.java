package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetCategoryIntentionsByCustomerIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class GetProductsFromCustomerIntentions {

    private final GetCategoryIntentionsByCustomerIdGateway getCategoryIntentionsByCustomerId;
    private final GetEnabledProductByCategoryIdUseCase getEnabledProductByCategoryIdUseCase;

    public List<ProductDomain> execute(String customerId) {
        return getCategoryIntentionsByCustomerId.execute(customerId).stream()
                .map(it -> getEnabledProductByCategoryIdUseCase.execute(it.getId()))
                .flatMap(Collection::stream)
                .collect(toList());
    }
}
