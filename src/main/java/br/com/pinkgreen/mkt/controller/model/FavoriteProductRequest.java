package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class FavoriteProductRequest implements Serializable {

    private Integer id;

    @NotBlank(message = "User ID not be blank")
    @ApiModelProperty(value = "ID do usuário", required = true, example = "64b5c9e4-8740-41f6-b66f-279631dff64e")
    private String userId;

    @NotNull(message = "Product ID not be null")
    @ApiModelProperty(value = "ID do produto", required = true, example = "1")
    private Integer productId;
}
