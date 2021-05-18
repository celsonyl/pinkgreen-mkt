package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CheckoutOrderResponse {

    @ApiModelProperty(value = "ID do cliente", example = "1f508dc081fd6db15d1d9056e457cd3f")
    private String customerId;

    @ApiModelProperty(value = "Número do pedido", example = "1036920")
    private String orderId;

    @ApiModelProperty(example = "Pedido recebido!")
    private String message;
}
