package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.Address;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CustomerRequest {

    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotBlank(message = "Lastname must not be blank")
    private String lastname;

    @CPF(message = "Document must be a valid CPF")
    @NotBlank(message = "Document must not be blank")
    private String document;

    @Email(message= "Must be a valid e-mail")
    @NotBlank(message = "E-mail must not be blank")
    private String email;

    private Address shippingAddress;
    private Address paymentAddress;
    private String phone;
}
