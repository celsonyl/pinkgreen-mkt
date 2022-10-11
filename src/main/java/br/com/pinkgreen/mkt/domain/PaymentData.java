package br.com.pinkgreen.mkt.domain;

import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class PaymentData implements Serializable {

    private PaymentMethod paymentMethod;
    private Map<String, String> paymentMethodProperties;
    private AddressDomain paymentAddress;

    public PaymentData(
            PaymentMethod paymentMethod,
            Map<String, String> paymentMethodProperties,
            AddressDomain paymentAddress
    ) {
        this.paymentMethod = paymentMethod;
        this.paymentMethodProperties = paymentMethodProperties;
        this.paymentAddress = paymentAddress;
    }
}
