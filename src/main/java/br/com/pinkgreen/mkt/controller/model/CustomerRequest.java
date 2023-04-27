package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CustomerRequest implements Serializable {

    public static final String PHONE_REGEX = "^(?:\\()[0-9]{2}(?:\\))\\s?[0-9]{4,5}(?:-)[0-9]{4}$";

    @NotBlank
    @NotNull
    @ApiModelProperty(value = "ID do cliente", required = true, example = "1f508dc081fd6db15d1d9056e457cd3f")
    private String id;

    @NotBlank(message = "Name must not be blank")
    @Length(min = 2, max = 200, message = "Name must have between 2 and 50 characters")
    @ApiModelProperty(value = "Primeiro nome do cliente", required = true, example = "Elza")
    private String name;

    @NotBlank(message = "Lastname must not be blank")
    @Length(min = 2, max = 200, message = "lastname must have between 2 and 50 characters")
    @ApiModelProperty(value = "Sobrenome do cliente", required = true, example = "Luna Rocha")
    private String lastname;

    @CPF(message = "Document must be a valid CPF")
    @NotBlank(message = "Document must not be blank")
    @ApiModelProperty(value = "CPF do cliente", required = true, example = "947.229.723-46")
    private String document;

    @Email(message = "Must be a valid e-mail")
    @NotBlank(message = "E-mail must not be blank")
    @ApiModelProperty(value = "E-mail do cliente", required = true, example = "test@test.com.br")
    private String email;

    @Pattern(
            regexp = PHONE_REGEX,
            message = "Field phone must be a valid phone"
    )
    @NotBlank(message = "Phone must not be blank")
    @ApiModelProperty(value = "Número de telefone do cliente", required = true, example = "+55 (19) 99999-9999")
    private String phone;
}
