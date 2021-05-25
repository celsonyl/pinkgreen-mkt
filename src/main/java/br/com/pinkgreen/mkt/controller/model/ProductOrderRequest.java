package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class ProductOrderRequest {

    @NotBlank
    @ApiModelProperty(value = "SKU do produto", required = true, example = "888888888")
    private String sku;

    @NotBlank(message = "Product name must not be blank")
    @Length(min = 2, max = 50, message = "Product name must have between 2 and 50 characters")
    @ApiModelProperty(value = "Nome do produto", required = true, example = "Samsung Galaxy S21 Cinza")
    private String name;

    @PositiveOrZero
    @ApiModelProperty(value = "Preço do produto", required = true, example = "3859.90")
    private Double price;

    @Positive
    @ApiModelProperty(value = "Quantidade do estoque do produto", required = true, example = "1000")
    private Integer quantity;

}
