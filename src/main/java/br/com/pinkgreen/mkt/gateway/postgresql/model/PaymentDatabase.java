package br.com.pinkgreen.mkt.gateway.postgresql.model;

import br.com.pinkgreen.mkt.domain.AddressDomain;
import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PaymentDatabase implements Serializable {

    private Double amount;
    private PaymentMethod paymentMethod;
    private AddressDomain paymentAddress;
}
