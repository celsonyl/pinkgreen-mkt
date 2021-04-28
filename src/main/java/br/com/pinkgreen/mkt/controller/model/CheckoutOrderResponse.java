package br.com.pinkgreen.mkt.controller.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CheckoutOrderResponse {
    private String customerId;
    private String orderId;
}
