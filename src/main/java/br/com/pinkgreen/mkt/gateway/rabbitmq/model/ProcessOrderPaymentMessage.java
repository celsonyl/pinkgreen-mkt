package br.com.pinkgreen.mkt.gateway.rabbitmq.model;

import br.com.pinkgreen.mkt.domain.PaymentDomain;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProcessOrderPaymentMessage {

    private String orderId;
    private PaymentDomain paymentDomain;
}
