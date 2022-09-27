package br.com.pinkgreen.mkt.gateway.postgresql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "PRODUCT")
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
    @JoinColumn(name = "PRODUCT_BRAND_ID")
    private BrandDatabase brand;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "PRODUCT_CATEGORIES",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID")
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
