package br.com.pinkgreen.mkt.gateway.postgresql.model;

import lombok.*;

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
public class ProductDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Boolean active;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "product_brand_id")
    private BrandDatabase brand;

    // Pensando ainda hmm, compilo os atributos na aplicação?
//    @Type(type = "jsonb")
//    @Column(columnDefinition = "jsonb")
//    private List<ProductAttributesDomain> productAttributes;

    @ManyToMany
    @JoinTable(
            name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryDatabase> categories = new ArrayList<>();
}
