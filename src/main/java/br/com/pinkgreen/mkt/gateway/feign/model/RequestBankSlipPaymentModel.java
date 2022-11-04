package br.com.pinkgreen.mkt.gateway.feign.model;

import br.com.pinkgreen.mkt.domain.AddressDomain;
import br.com.pinkgreen.mkt.domain.PaymentData;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalDate.now;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class RequestBankSlipPaymentModel implements Serializable {

    private String document;
    private String name;
    private String phone;
    private String email;
    private Double amount;
    private LocalDate dueDate;
    private AddressDomain paymentAddress;

    public static RequestBankSlipPaymentModel request(Double subtotal, PaymentData paymentData) {
        var map = paymentData.getPaymentMethodProperties();
        return new RequestBankSlipPaymentModel(
                map.get("document"),
                map.get("ownerName"),
                map.get("phone"),
                map.get("email"),
                subtotal,
                now().plusDays(4),
                paymentData.getPaymentAddress()
        );
    }

    public Map<String, String> properties() {
        HashMap<String, String> paymentProperties = new HashMap<>();
        paymentProperties.put("document", document);
        paymentProperties.put("phone", phone);
        paymentProperties.put("email", email);
        paymentProperties.put("ownerName", name);
        paymentProperties.put("dueDate", dueDate.toString());

        return paymentProperties;
    }
}
