package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ShippingDataResponse {

    @ApiModelProperty(value = "Preço da taxa de frete", required = true, example = "18.90")
    private Double freightPrice;

    @ApiModelProperty(value = "Dias úteis para entrega do pedido", required = true, example = "3")
    private Integer deliveryDays;

    private AddressResponse address;
}
