package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.ProductOrderDomain;
import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.domain.SkuPriceDomain;
import br.com.pinkgreen.mkt.domain.exception.CouldNotCheckoutOrderException;
import br.com.pinkgreen.mkt.gateway.PublishOrderStatusEvent;
import br.com.pinkgreen.mkt.gateway.SaveOrderGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.pinkgreen.mkt.domain.enums.OrderStatus.ORDER_CREATED;

@Slf4j
@Component
@RequiredArgsConstructor
public class CheckoutOrderUseCase {

    private final GetEnabledSkuBySkuCodeUseCase getEnabledSkuBySkuCodeUseCase;
    private final SaveOrderGateway saveOrderGateway;
    private final PublishOrderStatusEvent publishOrderStatusEvent;

    // TODO: validar estoque dos produtos no carrinho ao fazer checkout
    public OrderDomain execute(OrderDomain orderDomain) throws CouldNotCheckoutOrderException {
        validateReceivedSkus(orderDomain);
        setOrderStatusAndCalculateAmount(orderDomain);
        orderDomain.setCreatedAt(Instant.now());

        OrderDomain order = saveOrderGateway.execute(orderDomain);

        order.setPaymentData(orderDomain.getPaymentData());

        publishOrderStatusEvent.publish(order);
        return order;
    }

    private void setOrderStatusAndCalculateAmount(OrderDomain orderDomain) {
        orderDomain.setStatus(ORDER_CREATED);
        orderDomain.getPaymentData().setAmount(calcOrderAmount(orderDomain.getProductList()));
    }

    private Double calcOrderAmount(List<ProductOrderDomain> productOrderDomainList) {
        return productOrderDomainList.stream()
                .reduce(0.00, this::calcProductAmount, Double::sum);
    }

    private Double calcProductAmount(Double subtotal, ProductOrderDomain element) {
        return subtotal + getActivePrice(element.getPrice()) * element.getQuantity();
    }

    private Double getActivePrice(SkuPriceDomain skuPriceDomain) {
        var now = Instant.now();
        if (now.isBefore(skuPriceDomain.getEndDate()) && now.isAfter(skuPriceDomain.getStartDate())) {
            return skuPriceDomain.getSalePrice();
        }

        return skuPriceDomain.getListPrice();
    }

    private void validateReceivedSkus(OrderDomain orderDomain) throws CouldNotCheckoutOrderException {
        var productOrderDomains = orderDomain.getProductList();
        var skuDomainsDB = productOrderDomains.stream()
                .map(element -> getEnabledSkuBySkuCodeUseCase.getSkuBySkuCode(element.getSkuCode()))
                .collect(Collectors.toList());

        var validProducts = productOrderDomains.stream().filter(productOrderDomain -> skuDomainsDB.stream()
                        .anyMatch(skuDomain -> validateProductPrice(productOrderDomain.getPrice(), skuDomain.getPrice())
                                && skuDomain.getSkuCode().equals(productOrderDomain.getSkuCode())))
                .collect(Collectors.toList());

        if (validProducts.size() != skuDomainsDB.size()) {
            throw new CouldNotCheckoutOrderException("Erro no checkout!");
        }
        overrideProductList(orderDomain, skuDomainsDB);
    }

    private void overrideProductList(OrderDomain orderDomain, List<SkuDomain> skuDomainsDB) {
        var skus = skuDomainsDB.stream().collect(Collectors.toMap(SkuDomain::getSkuCode, skuDomain -> skuDomain));
        var updatedProductList = orderDomain.getProductList().stream().map(product -> {
            var skuDomain = skus.get(product.getSkuCode());
            return ProductOrderDomain.builder()
                    .skuCode(skuDomain.getSkuCode())
                    .name(skuDomain.getName())
                    .price(skuDomain.getPrice())
                    .stockQuantity(skuDomain.getStockQuantity())
                    .quantity(product.getQuantity())
                    .build();
        }).collect(Collectors.toList());
        orderDomain.setProductList(updatedProductList);
    }

    private boolean validateProductPrice(SkuPriceDomain receivedPrice, SkuPriceDomain databasePrice) {
        return receivedPrice.getListPrice().equals(databasePrice.getListPrice())
                && receivedPrice.getSalePrice().equals(databasePrice.getSalePrice())
                && receivedPrice.getStartDate().equals(databasePrice.getStartDate())
                && receivedPrice.getEndDate().equals(databasePrice.getEndDate());
    }
}
