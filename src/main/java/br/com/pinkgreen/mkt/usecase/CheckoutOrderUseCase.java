package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.*;
import br.com.pinkgreen.mkt.domain.exception.CouldNotCheckoutOrderException;
import br.com.pinkgreen.mkt.gateway.PublishOrderToProcessPayment;
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
    // TODO - Criptografar campos no 'paymentMethodProperties' caso o pagamento seja por cartão

    private final GetSkuBySkuCodeUseCase getSkuBySkuCodeUseCase;
    private final SaveOrderGateway saveOrderGateway;
    private final PublishOrderToProcessPayment publishOrderToProcessPayment;

    public OrderDomain execute(OrderDomain orderDomain, PaymentDomain paymentDomain) throws CouldNotCheckoutOrderException {
        validateReceivedSkus(orderDomain.getProductList());
        setOrderStatusAndCalculateAmount(orderDomain);
        OrderDomain order = saveOrderGateway.execute(orderDomain);

        publishOrderToProcessPayment.publish(order, paymentDomain);
        return order;
    }

    private void setOrderStatusAndCalculateAmount(OrderDomain orderDomain) {
        orderDomain.setStatus(ORDER_CREATED);
        orderDomain.getPaymentData().setAmount(calcOrderAmount(orderDomain.getProductList()));
    }

    private Double calcOrderAmount(List<ProductOrderDomain> productOrderDomainList) {
        return productOrderDomainList.stream().reduce(0.00, (subtotal, element) -> subtotal + getActivePrice(element.getPrice()), Double::sum);
    }

    private Double getActivePrice(SkuPriceDomain skuPriceDomain) {
        var now = Instant.now();
        if (now.isBefore(skuPriceDomain.getEndDate()) && now.isAfter(skuPriceDomain.getStartDate())) {
            return skuPriceDomain.getSalePrice();
        }

        return skuPriceDomain.getListPrice();
    }

    private void validateReceivedSkus(List<ProductOrderDomain> productOrderDomains) throws CouldNotCheckoutOrderException {
        var skuDomainsDB = productOrderDomains.stream()
                .map(element -> getSkuBySkuCodeUseCase.getSkuBySkuCode(element.getSkuCode()))
                .collect(Collectors.toList());

        var validProducts = productOrderDomains.stream().filter(productOrderDomain -> skuDomainsDB.stream()
                .anyMatch(skuDomain -> validateProductPrice(productOrderDomain.getPrice(), skuDomain.getPrice())
                        && skuDomain.getSkuCode().equals(productOrderDomain.getSkuCode())))
                .collect(Collectors.toList());

        if (validProducts.size() != skuDomainsDB.size()) {
            throw new CouldNotCheckoutOrderException("Erro no checkout!");
        }
    }

    private boolean validateProductPrice(SkuPriceDomain receivedPrice, SkuPriceDomain databasePrice) {
        return receivedPrice.getListPrice().equals(databasePrice.getListPrice())
                && receivedPrice.getSalePrice().equals(databasePrice.getSalePrice())
                && receivedPrice.getStartDate().equals(databasePrice.getStartDate())
                && receivedPrice.getEndDate().equals(databasePrice.getEndDate());
    }
}
