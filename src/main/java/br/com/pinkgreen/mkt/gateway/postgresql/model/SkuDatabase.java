package br.com.pinkgreen.mkt.gateway.postgresql.model;

import br.com.pinkgreen.mkt.domain.SkuAttributesDomain;
import br.com.pinkgreen.mkt.domain.SkuPriceDomain;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity(name = "PRODUCT_SKU")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class SkuDatabase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductDatabase product;

    @Column(unique = true)
    private String skuCode;

    private String name;
    private Integer stockQuantity;
    private Double height;
    private Double width;
    private Double length;
    private Double weight;
    private String mainImageUrl;
    private Boolean active;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<String> urlImages;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private SkuPriceDomain price;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<SkuAttributesDomain> skuAttributes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SkuDatabase that = (SkuDatabase) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 263293707;
    }
}
