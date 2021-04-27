package br.com.pinkgreen.mkt.controller.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class CheckoutRequest {

    private CustomerRequest customer;
}
