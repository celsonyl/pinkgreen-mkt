package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BrandResponse implements Serializable {

    @ApiModelProperty(value = "ID da marca", required = true, example = "1000258")
    private Integer id;

    @ApiModelProperty(value = "Nome da marca", required = true, example = "Samsung")
    private String name;

    @ApiModelProperty(value = "Imagem da marca", required = true, example = "https://imageDomain/path.extension")
    private String brandImage;
}
