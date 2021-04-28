package br.com.pinkgreen.mkt.domain;

import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDomain {

    private String id;
    private OrderStatus status;
    private CustomerDomain customer;
    private ShippingDataDomain shippingData;
    private List<ProductDomain> productList;
    private PaymentDomain payment;
    private Instant createdAt;
    private Instant updatedAt;
}
