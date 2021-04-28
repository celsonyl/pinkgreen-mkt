package br.com.pinkgreen.mkt.controller.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class ShippingDataRequest {

    @PositiveOrZero
    private Double freightPrice;

    @PositiveOrZero
    private Integer deliveryDays;

    @NotNull
    private AddressRequest addressDomain;

}
