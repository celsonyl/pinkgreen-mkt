package br.com.pinkgreen.mkt.controller.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CustomerRequest {

    @NotBlank
    private String id;

    @NotBlank(message = "Name must not be blank")
    @Length(min = 2, max = 50, message = "Name must have between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Lastname must not be blank")
    @Length(min = 2, max = 50, message = "lastname must have between 2 and 50 characters")
    private String lastname;

    @CPF(message = "Document must be a valid CPF")
    @NotBlank(message = "Document must not be blank")
    private String document;

    @Email(message = "Must be a valid e-mail")
    @NotBlank(message = "E-mail must not be blank")
    private String email;

    @Pattern(
            regexp = "/^(?:\\+)[0-9]{2}\\s?(?:\\()[0-9]{2}(?:\\))\\s?[0-9]{4,5}(?:-)[0-9]{4}$/",
            message = "Field phone must be a valid phone"
    )
    @NotBlank(message = "Phone must not be blank")
    private String phone;
}
