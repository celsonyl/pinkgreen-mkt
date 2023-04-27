package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.domain.CategoryDomain;
import io.swagger.annotations.ApiModelProperty;
import jdk.jfr.BooleanFlag;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ProductUpdateRequest implements Serializable {

    @Length(min = 2, max = 200, message = "Name must have between 2 and 50 characters")
    @ApiModelProperty(value = "Nome do Produto", required = true, example = "Samsung Galaxy S21 Cinza")
    private String name;

    @PositiveOrZero
    @ApiModelProperty(value = "Preço do produto", required = true, example = "2500")
    private Double price;

    @BooleanFlag
    private Boolean active;

    @ApiModelProperty(value = "Categoria do produto", example = "Eletrodoméstico")
    private List<CategoryRequest> categories;

    @ApiModelProperty(value = "Marca do produto", example = "Apple")
    private BrandRequest brand;

}
