package br.com.pinkgreen.mkt.gateway.postgresql.model;

import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.domain.ProductOrderDomain;
import br.com.pinkgreen.mkt.domain.SkuAttributesDomain;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderProductDatabase implements Serializable {
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

    public static OrderProductDatabase fromDomain(ProductOrderDomain products) {
        return new OrderProductDatabase(
                products.getSkuCode(),
                products.getName(),
                products.getActive(),
                products.getHeight(),
                products.getWidth(),
                products.getLength(),
                products.getWeight(),
                products.getMainImageUrl(),
                products.getUrlImages(),
                products.getPrice(),
                products.getSkuAttributes(),
                products.getProduct(),
                products.getQuantity()
        );
    }

    public static List<OrderProductDatabase> fromDomain(List<ProductOrderDomain> products) {
        return (products == null) ? null : products.stream()
                .map(OrderProductDatabase::fromDomain)
                .collect(toList());
    }

    public ProductOrderDomain toDomain() {
        return new ProductOrderDomain(
                skuCode,
                name,
                active,
                height,
                width,
                length,
                weight,
                mainImageUrl,
                urlImages,
                price,
                skuAttributes,
                product,
                quantity
        );
    }

    public static List<ProductOrderDomain> toDomain(List<OrderProductDatabase> products) {
        return (products == null) ? null : products.stream()
                .map(OrderProductDatabase::toDomain)
                .collect(toList());
    }
}
