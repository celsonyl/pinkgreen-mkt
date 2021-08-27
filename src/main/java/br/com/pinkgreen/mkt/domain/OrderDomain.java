package br.com.pinkgreen.mkt.domain;

import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDomain implements Serializable {

    private String id;
    private OrderStatus status;
    private CustomerDomain customerData;
    private ShippingDataDomain shippingData;
    private List<ProductOrderDomain> productList;
    private PaymentDomain paymentData;
    private Instant createdAt;
    private Instant updatedAt;

    public void setUpdatedAt() {
        this.updatedAt = Instant.now();
    }
}
