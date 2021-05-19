package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderResponse {

    @ApiModelProperty(value = "Número do pedido", example = "1036920")
    private String id;

    @ApiModelProperty(value = "Status atual do pedido")
    private OrderStatus status;

    private CustomerResponse customerData;

    private ShippingDataResponse shippingData;

    private List<ProductResponse> productList;

    private PaymentDataResponse paymentData;

    @ApiModelProperty(value = "Data de criação do pedido")
    private Instant createdAt;

    @ApiModelProperty(value = "Data da ultima atualização do pedido")
    private Instant updatedAt;
}
