package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.ShippingDataDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class ShippingDataRequest implements Serializable {

    @PositiveOrZero
    @ApiModelProperty(value = "Preço da taxa de frete", required = true, example = "18.90")
    private Double freightPrice;

    @PositiveOrZero
    @ApiModelProperty(value = "Dias úteis para entrega do pedido", required = true, example = "3")
    private Integer deliveryDays;

    @Valid
    @NotNull
    private AddressRequest address;

    public ShippingDataDomain toDomain() {
        return new ShippingDataDomain(
                freightPrice,
                deliveryDays,
                address.toDomain()
        );
    }
}
