package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SkuByProductIdResponse implements Serializable {

    @ApiModelProperty(value = "Cod do Sku", required = true, example = "CELPHX06")
    private String skuCode;

    @ApiModelProperty(value = "Nome do Sku", required = true, example = "Iphone X Cinza 64g")
    private String name;

    @ApiModelProperty(value = "Quantidade em estoque", required = true, example = "17")
    private Integer stockQuantity;

    @ApiModelProperty(value = "Altura do produto", required = true, example = "1.12")
    private Double height;

    @ApiModelProperty(value = "Largura do produto", required = true, example = "1.16")
    private Double width;

    @ApiModelProperty(value = "Comprimento do produto", required = true, example = "2.14")
    private Double length;

    @ApiModelProperty(value = "Peso do produto", required = true, example = "0.600")
    private Double weight;

    @ApiModelProperty(value = "Caminho da url que contêm a imagem do produto", required = true, example = "http://img.png")
    private String mainImageUrl;
    private List<String> urlImages;
    private SkuPriceResponse price;
    private List<SkuAttributesResponse> skuAttributes;

}
