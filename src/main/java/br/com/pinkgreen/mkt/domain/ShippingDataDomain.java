package br.com.pinkgreen.mkt.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ShippingDataDomain {

    private Double freightPrice;
    private Integer deliveryDays;
    private AddressDomain addressDomain;
}
