package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.AddressDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AddressRequest implements Serializable {

    public static final String PHONE_REGEX = "^(?:\\()[0-9]{2}(?:\\))\\s?[0-9]{4,5}(?:-)[0-9]{4}$";
    public static final String ZIPCODE_REGEX = "^([0-9]{2}[0-9]{3}-[0-9]{3})$";

    @NotBlank(message = "City must not be blank")
    @Length(min = 2, max = 60, message = "City name must have between 10 and 60 characters")
    @ApiModelProperty(value = "Cidade de entrega", required = true, example = "Limeira")
    private String city;

    @NotBlank(message = "State must not be blank")
    @Length(min = 2, max = 50, message = "State must have between 2 and 50 characters")
    @ApiModelProperty(value = "Estado de entrega", required = true, example = "SP")
    private String state;

    @NotBlank(message = "Country must not be blank")
    @Length(min = 2, max = 50, message = "Country must have between 2 and 50 characters")
    @ApiModelProperty(value = "País de entrega", required = true, example = "Brasil")
    private String country;

    @NotBlank(message = "Neighborhood must not be blank")
    @ApiModelProperty(value = "Bairro de entrega", required = true, example = "Centro")
    private String neighborhood;

    @NotBlank(message = "Zipcode must not be blank")
    @Pattern(
            regexp = ZIPCODE_REGEX,
            message = "Field Zip must be a valid zip"
    )
    @ApiModelProperty(value = "CEP de entrega", required = true, example = "13480-180")
    private String zipcode;

    @NotBlank(message = "Street must not be blank")
    @Length(min = 2, max = 60, message = "Street must have between 2 and 60 characters")
    @ApiModelProperty(value = "Rua de entrega", required = true, example = "R. Boa Morte")
    private String street;

    @NotNull
    @Length(max = 100, message = "Complement must have between 2 and 100 characters")
    @ApiModelProperty(value = "Complemento do endereço", required = true, example = "AP 190")
    private String complement;

    @NotNull(message = "Number must not be blank")
    @Positive
    @Max(99999)
    @ApiModelProperty(value = "Complemento do endereço", required = true, example = "380")
    private String number;

    @Pattern(
            regexp = PHONE_REGEX,
            message = "Field phone must be a valid phone"
    )
    @NotBlank(message = "Phone must not be blank")
    @ApiModelProperty(value = "Numero de contato", required = true, example = "(19) 99999-9999")
    private String phone;

    public AddressDomain toDomain() {
        return new AddressDomain(
                city,
                state,
                country,
                neighborhood,
                street,
                zipcode,
                complement,
                number,
                phone
        );
    }
}
