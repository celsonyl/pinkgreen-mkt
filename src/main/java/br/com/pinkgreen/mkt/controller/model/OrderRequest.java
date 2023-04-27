package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.controller.annotation.ValidPaymentData;
import br.com.pinkgreen.mkt.domain.CheckoutOrderData;
import br.com.pinkgreen.mkt.domain.CustomerDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class OrderRequest implements Serializable {

    @NotBlank(message = "CustomerId must not be blank")
    @Length(min = 2, max = 200, message = "customer must have between 2 and 50 characters")
    @ApiModelProperty(value = "Id do usuário", required = true, example = "64b5c9e4-8740-41f6-b66f-279631dff64e")
    private String customerId;

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

    public CheckoutOrderData data(CustomerDomain customer) {
        return new CheckoutOrderData(
                customer,
                shippingData.toDomain(),
                ProductOrderRequest.toDomain(productList)
        );
    }
}
