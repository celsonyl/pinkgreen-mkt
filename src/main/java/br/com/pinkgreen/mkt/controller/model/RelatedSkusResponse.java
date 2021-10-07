package br.com.pinkgreen.mkt.controller.model;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class RelatedSkusResponse implements Serializable {
    private Integer id;
    private ProductResponse product;
    private String skuCode;
    private String name;
    private String mainImageUrl;
    private SkuPriceResponse price;
}
