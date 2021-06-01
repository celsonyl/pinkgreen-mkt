package br.com.pinkgreen.mkt.domain;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class SkuDomain {
    private Integer id;
    private ProductDomain product;
    private String sku;
    private String name;
    private Integer stockQuantity;
    private Double height;
    private Double width;
    private Double length;
    private Double weight;
    private String mainImageUrl;
    private List<String> urlImages;
    private SkuPriceDomain price;
    private List<SkuAttributesDomain> skuAttributes;
}
