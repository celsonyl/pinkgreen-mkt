package br.com.pinkgreen.mkt.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Checkout {
    private String name;
    private String lastname;
    private String document;
    private String email;
    private Address shippingAddress;
    private Address paymentAddress;
    private String phone;
}
