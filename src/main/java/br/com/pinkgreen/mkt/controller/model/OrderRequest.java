package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.controller.annotation.ValidPaymentData;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class OrderRequest {

    @Valid
    @NotNull
    @ApiModelProperty(value = "Informações do cliente")
    private CustomerRequest customerData;

    @Valid
    @NotNull
    @ApiModelProperty(value = "Informações de entrega do pedido")
    private ShippingDataRequest shippingData;

    @Valid
    @NotNull
    @ApiModelProperty(value = "Lista de produtos que serão comprados pelo cliente")
    private List<ProductOrderRequest> productList;

    @Valid
    @ValidPaymentData(message = "propriedades invalidas")
    @ApiModelProperty(value = "Informações de pagamento")
    private PaymentDataRequest paymentData;
}
