package br.com.pinkgreen.mkt.gateway.feign.model;

import br.com.pinkgreen.mkt.domain.AddressDomain;
import br.com.pinkgreen.mkt.domain.PaymentData;
import lombok.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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
    private AddressDomain paymentAddress;

    public static RequestCardPaymentModel request(Double subtotal, PaymentData paymentData) {
        var map = paymentData.getPaymentMethodProperties();
        return RequestCardPaymentModel.builder()
                .cardNumber(map.get("cardNumber"))
                .cvv(map.get("cvv"))
                .validationDate(map.get("validationDate"))
                .document(map.get("document"))
                .ownerName(map.get("ownerName"))
                .phone(map.get("phone"))
                .email(map.get("email"))
                .paymentAddress(paymentData.getPaymentAddress())
                .amount(subtotal)
                .build();
    }

    public Map<String, String> properties() {
        HashMap<String, String> paymentProperties = new HashMap<>();
        paymentProperties.put("last4", cardNumber.substring(cardNumber.length() - 4));
        paymentProperties.put("validationDate", validationDate);
        paymentProperties.put("document", document);
        paymentProperties.put("phone", phone);
        paymentProperties.put("email", email);
        paymentProperties.put("ownerName", ownerName);

        return paymentProperties;
    }
}
