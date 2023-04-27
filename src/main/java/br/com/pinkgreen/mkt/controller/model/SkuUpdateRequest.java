package br.com.pinkgreen.mkt.controller.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SkuUpdateRequest implements Serializable {

    private String name;
    private double height;
    private double width;
    private double length;
    private double weight;
    private Boolean active;
    private Integer stockQuantity;
    private String mainImageUrl;
    private Integer index;
    private List<String> urlImages;
    private SkuPriceRequest price;
    private List<SkuAttributesRequest> skuAttributes;

}
