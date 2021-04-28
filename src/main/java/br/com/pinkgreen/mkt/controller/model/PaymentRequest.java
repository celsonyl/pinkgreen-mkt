package br.com.pinkgreen.mkt.controller.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class PaymentRequest {

    @Positive
    @NotNull
    private Integer installmentsNumber;

    @NotBlank
    @Length(min = 4, max = 4)
    private String creditCardLastForDigits;

    @NotNull
    private AddressRequest paymentAddress;
}
