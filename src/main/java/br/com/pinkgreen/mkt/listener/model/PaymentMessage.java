package br.com.pinkgreen.mkt.listener.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PaymentMessage {

    private String paymentId;
    private PaymentStatusMessage status;
}
