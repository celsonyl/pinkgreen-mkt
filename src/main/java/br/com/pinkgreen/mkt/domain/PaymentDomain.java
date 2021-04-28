package br.com.pinkgreen.mkt.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PaymentDomain {

    private Double subtotal;
    private Integer installmentsNumber;
    private Float installmentsValue;
    private String creditCardLastForDigits;
    private AddressDomain paymentAddress;
}
