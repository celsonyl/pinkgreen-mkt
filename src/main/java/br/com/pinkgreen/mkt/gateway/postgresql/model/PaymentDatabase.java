package br.com.pinkgreen.mkt.gateway.postgresql.model;

import br.com.pinkgreen.mkt.domain.AddressDomain;
import br.com.pinkgreen.mkt.domain.PaymentDomain;
import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PaymentDatabase implements Serializable {

    private String paymentId;
    private Double amount;
    private PaymentMethod paymentMethod;
    private Map<String, String> paymentProperties;
    private AddressDomain paymentAddress;

    public static PaymentDatabase fromDomain(PaymentDomain paymentData) {
        return (paymentData == null) ? null : new PaymentDatabase(
                paymentData.getPaymentId(),
                paymentData.getAmount(),
                paymentData.getPaymentMethod(),
                paymentData.getPaymentProperties(),
                paymentData.getPaymentAddress()
        );
    }

    public PaymentDomain toDomain() {
        return new PaymentDomain(
                paymentId,
                amount,
                paymentMethod,
                paymentProperties,
                paymentAddress
        );
    }
}
