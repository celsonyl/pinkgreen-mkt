package br.com.pinkgreen.mkt.domain;

import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PaymentDomain {

    private Double amount;
    private PaymentMethod paymentMethod;
    private Map<String, String> paymentMethodProperties;
    private AddressDomain paymentAddress;
}
