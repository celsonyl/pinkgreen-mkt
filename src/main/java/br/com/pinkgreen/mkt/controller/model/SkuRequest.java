package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class SkuRequest implements Serializable {

    @NotBlank
    @Length(min = 2, max = 200, message = "Name must have between 2 and 200 characters")
    @ApiModelProperty(value = "Cod do Sku", required = true, example = "CELPHX06")
    private String skuCode;

    @NotBlank
    @Length(min = 2, max = 50, message = "Name must have between 2 and 50 characters")
    @ApiModelProperty(value = "Nome do Sku", required = true, example = "Iphone X Cinza 64g")
    private String name;

    @PositiveOrZero
    @ApiModelProperty(value = "Quantidade em estoque", required = true, example = "17")
    private Integer stockQuantity;

    @PositiveOrZero
    @ApiModelProperty(value = "Altura do produto", required = true, example = "1.12")
    private Double height;

    @PositiveOrZero
    @ApiModelProperty(value = "Largura do produto", required = true, example = "1.16")
    private Double width;

    @PositiveOrZero
    @ApiModelProperty(value = "Comprimento do produto", required = true, example = "2.14")
    private Double length;

    @PositiveOrZero
    @ApiModelProperty(value = "Peso do produto", required = true, example = "0.600")
    private Double weight;

    @ApiModelProperty(value = "Estado do SKU", required = true, example = "true")
    private Boolean active = false;
    @ApiModelProperty(value = "Caminho da url que contêm a imagem do produto", required = true, example = "http://img.png")
    private String mainImageUrl;
    private List<String> urlImages;
    private SkuPriceRequest price;
    private List<SkuAttributesRequest> skuAttributes;
    private ProductRequest product;
}
