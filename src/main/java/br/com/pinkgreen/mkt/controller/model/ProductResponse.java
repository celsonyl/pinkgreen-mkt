package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

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

    @ApiModelProperty(value = "Estado do produto", required = true, example = "true")
    private boolean active;

    @ApiModelProperty(value = "Marca do produto", required = true, example = "{ \"id\": 1, \"name\": \"Samsung\" }")
    private BrandResponse brand;

    @ApiModelProperty(value = "Categorias do produto", required = true, example = "[ { \"id\": \"1\" }, { \"id\": \"2\" } ]")
    private List<CategoryResponse> categories;
}
