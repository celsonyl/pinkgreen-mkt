package br.com.pinkgreen.mkt.controller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryRequest {

    @NotBlank(message = "Field not be null or blank")
    @Length(min = 2,max = 50,message = "Name must have between 2 and 50 characters")
    private String name;
}
