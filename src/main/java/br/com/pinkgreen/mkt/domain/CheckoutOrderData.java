package br.com.pinkgreen.mkt.domain;

import lombok.*;

import java.util.List;

import static br.com.pinkgreen.mkt.domain.enums.OrderStatus.ORDER_CREATED;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CheckoutOrderData {
    private CustomerDomain customerData;
    private ShippingDataDomain shippingData;
    private List<CheckoutOrderProductData> productList;

    public OrderDomain toDomain(List<ProductOrderDomain> products) {
        return new OrderDomain(
                ORDER_CREATED,
                customerData,
                shippingData,
                products
        );
    }
}
