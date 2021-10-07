package br.com.pinkgreen.mkt.domain;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class RelatedSkusDomain implements Serializable {
    private Integer id;
    private ProductDomain product;
    private String skuCode;
    private String name;
    private String mainImageUrl;
    private SkuPriceDomain price;
}
