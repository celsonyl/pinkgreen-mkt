package br.com.pinkgreen.mkt.domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class ProductDomain implements Serializable {
    private Integer id;
    private String name;
    private Double price;
    private Boolean active;
    private BrandDomain brand;
    private List<CategoryDomain> categories;
}
