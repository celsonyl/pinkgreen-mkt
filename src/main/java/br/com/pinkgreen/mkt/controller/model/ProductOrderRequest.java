package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class ProductOrderRequest implements Serializable {

    @NotBlank
    @Length(min = 2, max = 50, message = "Name must have between 2 and 50 characters")
    @ApiModelProperty(value = "Cod do Sku", required = true, example = "CELPHX06")
    private String skuCode;

    @NotBlank(message = "Product name must not be blank")
    @Length(min = 2, max = 150, message = "Product name must have between 2 and 150 characters")
    @ApiModelProperty(value = "Nome do produto", required = true, example = "Samsung Galaxy S21 Cinza")
    private String name;

    @ApiModelProperty(value = "Preço do produto", required = true, example = "3859.90")
    private SkuPriceRequest price;

    @PositiveOrZero
    @ApiModelProperty(value = "Quantidade em estoque", required = true, example = "17")
    private Integer stockQuantity;

}
