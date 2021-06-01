package br.com.pinkgreen.mkt.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductOrderDomain implements Serializable {

    private String sku;
    private String name;
    private Double price;
    private Integer quantity;
}
