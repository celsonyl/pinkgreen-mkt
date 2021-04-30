package br.com.pinkgreen.mkt.gateway.postgresql.model;

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

    // TODO - Salvar este enum como texto em banco, esta sendo salvo com um número
    private OrderStatus status;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private CustomerDatabase customerData;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private ShippingDataDatabase shippingData;

    // TODO - Ajustar atributo 'productList' para salvar como JsonB, esta dando problemas :/
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<ProductDatabase> productList;

    // TODO - Persistir informações de pagamento (somente não persistir campo paymentMethodProperties)

    private Instant createdAt;
    private Instant updatedAt;
}
