package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.exception.ObjectNotFoundException;
import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.GetEnabledProductByIdGateway;
import br.com.pinkgreen.mkt.gateway.RegisterCustomerCategoryIntentionGateway;
import br.com.pinkgreen.mkt.gateway.RegisterCustomerProductAccessGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetEnabledProductByIdUseCase {

    private final GetEnabledProductByIdGateway getEnabledProductByIdGateway;
    private final RegisterCustomerCategoryIntentionGateway registerCustomerCategoryIntention;
    private final RegisterCustomerProductAccessGateway registerCustomerProductAccess;

    public ProductDomain findById(Integer id, String customerId) {
        ProductDomain product = getEnabledProductByIdGateway.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado: " + id));
        if(customerId != null) {
            registerCustomerCategoryIntention.execute(customerId, product.getCategories());
            registerCustomerProductAccess.execute(customerId, product.getId());
        }
        return product;
    }
}
