package br.com.pinkgreen.mkt.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ShippingDataDomain implements Serializable {

    private Double freightPrice;
    private Integer deliveryDays;
    private AddressDomain address;
}
