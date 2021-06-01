package br.com.pinkgreen.mkt.controller.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class SkuRequest implements Serializable {

    private ProductRequest product;
    private String sku;
    private String name;
    private Integer stockQuantity;
    private Double height;
    private Double width;
    private Double length;
    private Double weight;
    private String mainImageUrl;
    private List<String> urlImages;
    private SkuPriceRequest price;
    private List<SkuAttributesRequest> skuAttributes;
}
