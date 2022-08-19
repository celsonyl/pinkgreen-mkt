package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    public static final String PASSWORD_REGEX = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$";
    public static final String PHONE_REGEX = "^((?:\\+)[0-9]{2}\\s?(?:\\()[0-9]{2}(?:\\))\\s?[0-9]{4,5}(?:-)[0-9]{4})$";

    @NotBlank(message = "Name must not be blank")
    @Length(min = 2, max = 50, message = "Name must have between 2 and 50 characters")
    @ApiModelProperty(value = "Primeiro nome do cliente", required = true, example = "Elza")
    private String firstName;

    @NotBlank(message = "Lastname must not be blank")
    @Length(min = 2, max = 50, message = "lastname must have between 2 and 50 characters")
    @ApiModelProperty(value = "Sobrenome do cliente", required = true, example = "Luna Rocha")
    private String lastName;

    @Email(message = "Must be a valid e-mail")
    @NotBlank(message = "E-mail must not be blank")
    @ApiModelProperty(value = "E-mail do cliente", required = true, example = "test@test.com.br")
    private String email;

    @CPF(message = "Document must be a valid CPF")
    @NotBlank(message = "Document must not be blank")
    @ApiModelProperty(value = "CPF do cliente", required = true, example = "947.229.723-46")
    private String document;

    @NotBlank(message = "Phone must not be blank")
    @Pattern(regexp = PHONE_REGEX, message = "Field phone must be a valid phone")
    @ApiModelProperty(value = "Número de telefone do cliente", required = true, example = "+55 (19) 99999-9999")
    private String phone;

    @NotNull(message = "Birthday must not be null")
    @ApiModelProperty(value = "Data de nascimento do cliente", required = true, example = "2002-08-11")
    private LocalDate birthday;

    @NotBlank(message = "Invalid password")
    @Pattern(regexp = PASSWORD_REGEX, message = "Invalid password")
    @ApiModelProperty(value = "Senha da conta do cliente", required = true, example = "SenhaF0rt3@2022")
    private String password;
}
