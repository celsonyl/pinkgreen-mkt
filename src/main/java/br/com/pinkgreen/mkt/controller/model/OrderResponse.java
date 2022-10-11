package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderResponse implements Serializable {

    @ApiModelProperty(value = "Número do pedido", example = "1036920")
    private Integer id;

    @ApiModelProperty(value = "Status atual do pedido")
    private OrderStatus status;

    private CustomerResponse customerData;

    private ShippingDataResponse shippingData;

    private List<ProductOrderResponse> productList;

    private PaymentDataResponse paymentData;

    @ApiModelProperty(value = "Data de criação do pedido")
    private Instant createdAt;

    @ApiModelProperty(value = "Data da ultima atualização do pedido")
    private Instant updatedAt;

    public static OrderResponse response(OrderDomain order) {
        return new OrderResponse(
                order.getId(),
                order.getStatus(),
                CustomerResponse.fromDomain(order.getCustomerData()),
                ShippingDataResponse.fromDomain(order.getShippingData()),
                ProductOrderResponse.fromDomain(order.getProductList()),
                PaymentDataResponse.fromDomain(order.getPaymentData()),
                order.getCreatedAt(),
                order.getUpdatedAt()
        );
    }
}
