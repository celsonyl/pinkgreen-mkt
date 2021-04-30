package br.com.pinkgreen.mkt.controller.model;

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
    private CustomerRequest customerData;

    @Valid
    @NotNull
    private ShippingDataRequest shippingData;

    @Valid
    @NotNull
    private List<ProductRequest> productList;

    @Valid
    @NotNull
    private PaymentDataRequest paymentData;
}
