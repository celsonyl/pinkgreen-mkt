package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductResponse {

    @ApiModelProperty(value = "Id do produto", required = true, example = "1")
    private Integer id;

    @ApiModelProperty(value = "Nome do produto", required = true, example = "Samsung Galaxy S21 Cinza")
    private String name;

    @ApiModelProperty(value = "Preço do produto", required = true, example = "1250.90")
    private double price;

    @ApiModelProperty(value = "Estado do produto", required = true, example = "Esgotado")
    private boolean active;

    private Integer brandResponse;

}
