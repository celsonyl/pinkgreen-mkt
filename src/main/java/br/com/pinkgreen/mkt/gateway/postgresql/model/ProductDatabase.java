package br.com.pinkgreen.mkt.gateway.postgresql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "product")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDatabase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Boolean active;
    private String mainImageUrl;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductDatabase that = (ProductDatabase) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 52800968;
    }
}
