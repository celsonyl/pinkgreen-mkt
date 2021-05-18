package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.Valid;
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
    @ApiModelProperty(value = "Preço da taxa de frete", required = true, example = "18.90")
    private Double freightPrice;

    @PositiveOrZero
    @ApiModelProperty(value = "Dias úteis para entrega do pedido", required = true, example = "3")
    private Integer deliveryDays;

    @Valid
    @NotNull
    private AddressRequest address;

}
