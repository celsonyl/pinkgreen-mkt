package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BrandResponse {

    @ApiModelProperty(value = "ID da marca", required = true, example = "1000258")
    private Integer id;

    @ApiModelProperty(value = "Nome da marca", required = true, example = "Samsung")
    private String name;
}
