package br.com.pinkgreen.mkt.gateway.postgresql.model;

import br.com.pinkgreen.mkt.domain.CustomerDomain;
import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.ShippingDataDomain;
import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity(name = "ORDERS")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class OrderDatabase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private CustomerDomain customerData;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private ShippingDataDomain shippingData;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<OrderProductDatabase> productList;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private PaymentDatabase paymentData;

    private Instant createdAt;
    private Instant updatedAt;

    public static OrderDatabase database(OrderDomain order) {
        return new OrderDatabase(
                order.getId(),
                order.getStatus(),
                order.getCustomerData(),
                order.getShippingData(),
                OrderProductDatabase.fromDomain(order.getProductList()),
                PaymentDatabase.fromDomain(order.getPaymentData()),
                order.getCreatedAt(),
                order.getUpdatedAt()
        );
    }

    public OrderDomain toDomain() {
        return new OrderDomain(
                id,
                status,
                customerData,
                shippingData,
                OrderProductDatabase.toDomain(productList),
                (paymentData == null) ? null : paymentData.toDomain(),
                null,
                createdAt,
                updatedAt
        );
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderDatabase that = (OrderDatabase) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1960981007;
    }
}
