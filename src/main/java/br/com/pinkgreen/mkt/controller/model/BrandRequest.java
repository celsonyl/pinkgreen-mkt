package br.com.pinkgreen.mkt.controller.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BrandRequest {

    @NotBlank(message = "Field not be null or blank")
    @Length(min = 2, max = 50, message = "Name must have between 2 and 50 characters")
    private String name;
}