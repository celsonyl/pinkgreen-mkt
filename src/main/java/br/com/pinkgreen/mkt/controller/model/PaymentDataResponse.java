package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PaymentDataResponse implements Serializable {

    @ApiModelProperty(value = "Preço total da compra", required = true, example = "9900.99")
    private Double amount;
    private PaymentMethod paymentMethod;
    private AddressResponse paymentAddress;
}
