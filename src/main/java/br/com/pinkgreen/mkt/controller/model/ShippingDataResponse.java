package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.ShippingDataDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ShippingDataResponse implements Serializable {

    @ApiModelProperty(value = "Preço da taxa de frete", required = true, example = "18.90")
    private Double freightPrice;

    @ApiModelProperty(value = "Dias úteis para entrega do pedido", required = true, example = "3")
    private Integer deliveryDays;

    private AddressResponse address;

    public static ShippingDataResponse fromDomain(ShippingDataDomain shippingData) {
        return (shippingData == null) ? null : new ShippingDataResponse(
                shippingData.getFreightPrice(),
                shippingData.getDeliveryDays(),
                AddressResponse.fromDomain(shippingData.getAddress())
        );
    }
}
