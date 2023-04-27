package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest implements Serializable {

    @ApiModelProperty(value = "ID da categoria", required = true, example = "1000258")
    private Integer id;

    @NotBlank(message = "Field not be null or blank")
    @Length(min = 2, max = 200, message = "Name must have between 2 and 50 characters")
    @ApiModelProperty(value = "Nome da categoria", required = true, example = "Celulares e Smartphones")
    private String name;

    @NotBlank(message = "Field not be null or blank")
    @ApiModelProperty(value = "Imagem da categoria", required = true, example = "https://imageDomain/path.extension")
    private String image;
}
