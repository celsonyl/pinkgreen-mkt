package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.PaymentDomain;
import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PaymentDataResponse implements Serializable {

    @ApiModelProperty(value = "Preço total da compra", required = true, example = "9900.99")
    private Double amount;
    private PaymentMethod paymentMethod;
    private Map<String, String> paymentProperties;
    private AddressResponse paymentAddress;

    public static PaymentDataResponse fromDomain(PaymentDomain paymentData) {
        return (paymentData == null) ? null : new PaymentDataResponse(
                paymentData.getAmount(),
                paymentData.getPaymentMethod(),
                paymentData.getPaymentProperties(),
                AddressResponse.fromDomain(paymentData.getPaymentAddress())
        );
    }
}
