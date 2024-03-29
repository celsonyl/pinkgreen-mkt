package br.com.pinkgreen.mkt.domain;

import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@EqualsAndHashCode
public class PaymentDomain implements Serializable {

    private String paymentId;
    private Double amount;
    private PaymentMethod paymentMethod;
    private Map<String, String> paymentProperties;
    private AddressDomain paymentAddress;

    public PaymentDomain(
            String paymentId,
            Double amount,
            PaymentMethod paymentMethod,
            Map<String, String> paymentProperties,
            AddressDomain paymentAddress
    ) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentProperties = paymentProperties;
        this.paymentAddress = paymentAddress;
    }
}
