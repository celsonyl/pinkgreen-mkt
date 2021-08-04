package br.com.pinkgreen.mkt.gateway.feign.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class ResponseCardPaymentModel {
    private String paymentId;
}
