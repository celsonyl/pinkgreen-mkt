package br.com.pinkgreen.mkt.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutOrderProductData {
    private String skuCode;
    private SkuPriceDomain price;
    private Integer quantity;
}
