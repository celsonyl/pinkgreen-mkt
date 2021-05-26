package br.com.pinkgreen.mkt.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class ProductDomain {
    private Integer id;
    private String name;
    private Double price;
    private boolean active;
    private BrandDomain brand;
    private List<CategoryDomain> categories;
}
