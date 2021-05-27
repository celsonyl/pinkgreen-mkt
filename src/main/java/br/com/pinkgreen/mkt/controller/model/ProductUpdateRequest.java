package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import jdk.jfr.BooleanFlag;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ProductUpdateRequest {

    @Length(min = 2, max = 50, message = "Name must have between 2 and 50 characters")
    @ApiModelProperty(value = "Nome do Produto", required = true, example = "Samsung Galaxy S21 Cinza")
    private String name;

    @PositiveOrZero
    @ApiModelProperty(value = "Preço do produto", required = true, example = "2500")
    private Double price;

    @BooleanFlag
    private Boolean active;
}
