package br.com.pinkgreen.mkt.controller.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class ProductRequest {

    @NotBlank
    private String sku;

    @NotBlank(message = "Product name must not be blank")
    @Length(min = 2, max = 50, message = "Product name must have between 2 and 50 characters")
    private String name;

    @PositiveOrZero
    private Double price;

    @Positive
    private Integer quantity;

}
