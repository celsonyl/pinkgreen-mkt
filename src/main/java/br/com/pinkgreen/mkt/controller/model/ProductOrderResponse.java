package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductOrderResponse implements Serializable {

    @ApiModelProperty(value = "SKU do produto", required = true, example = "888888888")
    private String sku;

    @ApiModelProperty(value = "Nome do produto", required = true, example = "Samsung Galaxy S21 Cinza")
    private String name;

    @ApiModelProperty(value = "Preço do produto", required = true, example = "3859.90")
    private Double price;

    @ApiModelProperty(value = "Quantidade do estoque do produto", required = true, example = "1000")
    private Integer quantity;
}
