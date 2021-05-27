package br.com.pinkgreen.mkt.controller.model;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class SkuRequest {

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
    private SkuPrice price;
    private List<SkuAttributesRequest> skuAttributes;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Builder
    public static class ProductRequest {
        private Integer id;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class SkuAttributesRequest {
        private String label;
        private String type;
        private String value;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class SkuPrice {
        private Double listPrice;
        private Double salePrice;
        private Instant startDate;
        private Instant endDate;
    }
}
