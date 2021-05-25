package br.com.pinkgreen.mkt.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductOrderDomain {

    private String sku;
    private String name;
    private Double price;
    private Integer quantity;
}
