package br.com.pinkgreen.mkt.gateway.postgresql.model;

import br.com.pinkgreen.mkt.domain.SkuAttributesDomain;
import br.com.pinkgreen.mkt.domain.SkuPriceDomain;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "product_sku")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class SkuDatabase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductDatabase product;

    private String sku;
    private String name;
    private Integer stockQuantity;
    private Double height;
    private Double width;
    private Double length;
    private Double weight;
    private String mainImageUrl;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<String> urlImages;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private SkuPriceDomain price;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<SkuAttributesDomain> skuAttributes;

}
