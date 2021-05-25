package br.com.pinkgreen.mkt.domain;

import br.com.pinkgreen.mkt.controller.model.BrandRequest;
import lombok.*;

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
    private BrandRequest brand;
}
