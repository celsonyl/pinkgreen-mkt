package br.com.pinkgreen.mkt.gateway.postgresql.model;

import br.com.pinkgreen.mkt.domain.SkuAttributesDomain;
import br.com.pinkgreen.mkt.domain.SkuPriceDomain;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class ProductSkuDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductDatabase product;

    private String sku;
    private String name;
    private Integer stockQuantity;
    private Float height;
    private Float width;
    private Float length;
    private Float weight;
    private String mainImageUrl;
    private String urlImages;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private SkuPriceDomain price;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<SkuAttributesDomain> skuAttributes = new ArrayList<>();

}
