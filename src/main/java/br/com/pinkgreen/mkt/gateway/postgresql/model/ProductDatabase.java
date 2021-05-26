package br.com.pinkgreen.mkt.gateway.postgresql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "product")
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

    @ManyToOne
    @JoinColumn(name = "product_brand_id")
    private BrandDatabase brand;

    // Pensando ainda hmm, compilo os atributos na aplicação?
//    @Type(type = "jsonb")
//    @Column(columnDefinition = "jsonb")
//    private List<ProductAttributesDomain> productAttributes;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryDatabase> categories = new ArrayList<>();
}
