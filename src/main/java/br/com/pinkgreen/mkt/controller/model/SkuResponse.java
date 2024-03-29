package br.com.pinkgreen.mkt.controller.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SkuResponse implements Serializable {
    private Integer id;
    private String skuCode;
    private String name;
    private Integer stockQuantity;
    private Boolean active;
    private Double height;
    private Double width;
    private Double length;
    private Double weight;
    private String mainImageUrl;
    private Integer index;
    private List<String> urlImages;
    private SkuPriceResponse price;
    private List<SkuAttributesResponse> skuAttributes;
    private ProductResponse product;
    private List<RelatedSkusResponse> relatedSkus;

}
