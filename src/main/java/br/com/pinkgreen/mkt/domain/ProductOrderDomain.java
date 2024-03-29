package br.com.pinkgreen.mkt.domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductOrderDomain implements Serializable {
    private String skuCode;
    private String name;
    private Boolean active;
    private Double height;
    private Double width;
    private Double length;
    private Double weight;
    private String mainImageUrl;
    private List<String> urlImages;
    private Double price;
    private List<SkuAttributesDomain> skuAttributes;
    private ProductDomain product;
    private Integer quantity;

    public ProductOrderDomain(SkuDomain sku, Integer quantity) {
        this.skuCode = sku.getSkuCode();
        this.name = sku.getName();
        this.active = sku.getActive();
        this.height = sku.getHeight();
        this.width = sku.getWidth();
        this.length = sku.getLength();
        this.weight = sku.getWeight();
        this.mainImageUrl = sku.getMainImageUrl();
        this.urlImages = sku.getUrlImages();
        this.price = sku.getPrice().activePrice();
        this.skuAttributes = sku.getSkuAttributes();
        this.product = sku.getProduct();
        this.quantity = quantity;
    }

    public static Map<String, Integer> getProductInfo(List<ProductOrderDomain> products) {
        return products.stream().collect(toMap(ProductOrderDomain::getSkuCode, ProductOrderDomain::getQuantity));
    }
}
