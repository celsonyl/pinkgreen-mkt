package br.com.pinkgreen.mkt.gateway.rabbitmq.model;

import br.com.pinkgreen.mkt.domain.PaymentData;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProcessOrderCheckoutMessage {

    private Integer orderId;
    private PaymentData paymentData;

    public static ProcessOrderCheckoutMessage message(Integer orderId, PaymentData paymentData) {
        return new ProcessOrderCheckoutMessage(orderId, paymentData);
    }
}
