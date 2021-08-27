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

    private String skuCode;
    private String name;
    private SkuPriceDomain price;
    private Integer stockQuantity;
    private Integer quantity;
}
