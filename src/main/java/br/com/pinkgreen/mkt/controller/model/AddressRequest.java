package br.com.pinkgreen.mkt.controller.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AddressRequest {

    @NotBlank(message = "City must not be blank")
    @Length(min = 10, max = 60, message = "City name must have between 10 and 60 characters")
    private String city;

    @NotBlank(message = "State must not be blank")
    @Length(min = 2, max = 50, message = "State must have between 2 and 50 characters")
    private String state;

    @NotBlank(message = "Country must not be blank")
    @Length(min = 2, max = 50, message = "Country must have between 2 and 50 characters")
    private String country;

    @NotBlank(message = "Neighborhood must not be blank")
    private String neighborhood;

    @NotBlank(message = "Zipcode must not be blank")
    @Pattern(
            regexp = "([0-9]{2}[0-9]{3}-[0-9]{3})$",
            message = "Field Zip must be a valid zip"
    )
    private String zipcode;

    @NotBlank
    @Length(min = 2, max = 100, message = "Complement must have between 2 and 50 characters")
    private String complement;

    @NotNull(message = "Number must not be blank")
    @Positive
    @Max(99999)
    private String number;

    @Pattern(
            regexp = "/^(?:\\+)[0-9]{2}\\s?(?:\\()[0-9]{2}(?:\\))\\s?[0-9]{4,5}(?:-)[0-9]{4}$/",
            message = "Field phone must be a valid phone"
    )
    @NotBlank(message = "Phone must not be blank")
    private String phone;
}
