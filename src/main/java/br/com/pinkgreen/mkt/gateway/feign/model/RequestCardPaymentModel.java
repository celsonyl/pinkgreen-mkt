package br.com.pinkgreen.mkt.gateway.feign.model;

import br.com.pinkgreen.mkt.domain.AddressDomain;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class RequestCardPaymentModel implements Serializable {

    private String cardNumber;
    private String cvv;
    private String validationDate;
    private String document;
    private String ownerName;
    private String phone;
    private String email;
    private Double amount;
    private AddressDomain addressDomain;
}
