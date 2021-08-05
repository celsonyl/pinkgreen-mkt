package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse implements Serializable {

    @ApiModelProperty(value = "ID da categoria", required = true, example = "1000258")
    private Integer id;

    @ApiModelProperty(value = "Nome da categoria", required = true, example = "Celulares e Smartphones")
    private String name;

    @ApiModelProperty(value = "Imagem da categoria", required = true, example = "https://imageDomain/path.extension")
    private String image;
}
