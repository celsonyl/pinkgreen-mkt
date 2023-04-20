package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.*;
import br.com.pinkgreen.mkt.domain.exception.CouldNotCheckoutOrderException;
import br.com.pinkgreen.mkt.gateway.ProcessOrderCheckout;
import br.com.pinkgreen.mkt.gateway.SaveOrderGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@Slf4j
@Component
@RequiredArgsConstructor
public class CheckoutOrderUseCase {

    private final GetEnabledSkuBySkuCodeUseCase getEnabledSkuBySkuCodeUseCase;
    private final SaveOrderGateway saveOrderGateway;
    private final ProcessOrderCheckout processOrderCheckout;

    // TODO: validar estoque dos produtos no carrinho ao fazer checkout
    public OrderDomain execute(CheckoutOrderData data, PaymentData paymentData) throws CouldNotCheckoutOrderException {
        List<ProductOrderDomain> products = getProducts(data);

        OrderDomain order = saveOrderGateway.execute(data.toDomain(products));

        processOrderCheckout.publish(order.getId(), paymentData);
        return order;
    }

    private List<ProductOrderDomain> getProducts(CheckoutOrderData data) throws CouldNotCheckoutOrderException {
        var productData = data.getProductList().stream().collect(toMap(CheckoutOrderProductData::getSkuCode, it -> it));
        List<ProductOrderDomain> products = data.getProductList().stream()
                .map(element -> getEnabledSkuBySkuCodeUseCase.getSkuBySkuCode(element.getSkuCode()))
                .filter(it -> it.getStockQuantity() > 0)
                .filter(it -> productData.get(it.getSkuCode()).getQuantity() <= it.getStockQuantity())
                .filter(it -> productData.get(it.getSkuCode()).getPrice().equals(it.getPrice()))
                .map(it -> new ProductOrderDomain(it, productData.get(it.getSkuCode()).getQuantity()))
                .collect(toList());

        if (productData.size() != products.size()) {
            throw new CouldNotCheckoutOrderException("Erro no checkout!");
        }

        return products;
    }
}
