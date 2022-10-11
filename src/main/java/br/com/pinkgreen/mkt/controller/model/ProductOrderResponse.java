package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.ProductOrderDomain;
import br.com.pinkgreen.mkt.domain.SkuAttributesDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductOrderResponse implements Serializable {
    @ApiModelProperty(value = "SKU do produto", required = true, example = "888888888")
    private String skuCode;

    @ApiModelProperty(value = "Nome do produto", required = true, example = "Samsung Galaxy S21 Cinza")
    private String name;

    @ApiModelProperty(value = "Altura do produto", required = true, example = "1.12")
    private Double height;

    @ApiModelProperty(value = "Largura do produto", required = true, example = "1.16")
    private Double width;

    @ApiModelProperty(value = "Preço do produto", required = true, example = "2.14")
    private Double length;

    @ApiModelProperty(value = "Peso do produto", required = true, example = "0.600")
    private Double weight;

    @ApiModelProperty(value = "Preço do produto", required = true, example = "3859.90")
    private String mainImageUrl;

    @ApiModelProperty(value = "Caminho da url que contêm a imagem do produto", required = true, example = "http://img.png")
    private List<String> urlImages;

    @ApiModelProperty(value = "Preço do produto", required = true, example = "3859.90")
    private Double price;

    @ApiModelProperty(value = "Atributos do produto", required = true)
    private List<SkuAttributesDomain> skuAttributes;

    @ApiModelProperty(value = "Quantidade de itens do produto", required = true, example = "1")
    private Integer quantity;

    public static ProductOrderResponse fromDomain(ProductOrderDomain product) {
        return (product == null) ? null : new ProductOrderResponse(
                product.getSkuCode(),
                product.getName(),
                product.getHeight(),
                product.getWidth(),
                product.getLength(),
                product.getWeight(),
                product.getMainImageUrl(),
                product.getUrlImages(),
                product.getPrice(),
                product.getSkuAttributes(),
                product.getQuantity()
        );
    }
    public static List<ProductOrderResponse> fromDomain(List<ProductOrderDomain> products) {
        return (products == null) ? null : products.stream()
                .map(ProductOrderResponse::fromDomain)
                .collect(toList());
    }
}
