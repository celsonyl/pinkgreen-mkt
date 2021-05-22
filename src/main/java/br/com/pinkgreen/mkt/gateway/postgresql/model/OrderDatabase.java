package br.com.pinkgreen.mkt.gateway.postgresql.model;

import br.com.pinkgreen.mkt.domain.CustomerDomain;
import br.com.pinkgreen.mkt.domain.ShippingDataDomain;
import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class OrderDatabase {

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
}
