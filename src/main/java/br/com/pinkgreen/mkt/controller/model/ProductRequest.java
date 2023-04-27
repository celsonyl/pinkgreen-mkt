package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import jdk.jfr.BooleanFlag;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ProductRequest implements Serializable {

    private Integer id;

    @NotBlank(message = "Field not be null or blank")
    @Length(min = 2, max = 200, message = "Name must have between 2 and 50 characters")
    @ApiModelProperty(value = "Nome do Produto", required = true, example = "Samsung Galaxy S21 Cinza")
    private String name;

    @PositiveOrZero

    @NotNull(message = "Field not be null")

    @ApiModelProperty(value = "Preço do produto", required = true, example = "2500")
    private Double price;

    @NotNull(message = "Field not be null")
    @BooleanFlag
    private Boolean active;

    @NotNull(message = "Field not be null")
    private BrandRequest brand;

    @ApiModelProperty(value = "Imagem do produto", required = true, example = "https://imageDomain/path.extension")
    private String mainImageUrl;

    @NotNull
    @ApiModelProperty(value = "Categorias do produto", required = true, example = "[ { \"id\": \"1\" }, { \"id\": \"2\" } ]")
    private List<CategoryRequest> categories;
    
}
