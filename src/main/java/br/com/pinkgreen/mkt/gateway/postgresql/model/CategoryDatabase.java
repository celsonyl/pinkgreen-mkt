package br.com.pinkgreen.mkt.gateway.postgresql.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "PRODUCT_CATEGORY")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDatabase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    private String image;

    @ManyToMany(mappedBy = "categories")
    private List<ProductDatabase> products = new ArrayList<>();

    public CategoryDatabase(Integer id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CategoryDatabase that = (CategoryDatabase) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 842842352;
    }
}
