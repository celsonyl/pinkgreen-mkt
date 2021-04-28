package br.com.pinkgreen.mkt.controller.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class OrderRequest {

    @NotNull
    private CustomerRequest customer;

    @NotNull
    private ShippingDataRequest shippingData;

    @NotNull
    private List<ProductRequest> productList;
}
