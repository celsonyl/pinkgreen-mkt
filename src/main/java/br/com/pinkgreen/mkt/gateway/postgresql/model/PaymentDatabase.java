package br.com.pinkgreen.mkt.gateway.postgresql.model;

import br.com.pinkgreen.mkt.domain.AddressDomain;
import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PaymentDatabase {

    private Double amount;
    private PaymentMethod paymentMethod;
    private AddressDomain paymentAddress;
}
