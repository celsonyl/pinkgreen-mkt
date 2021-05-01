package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class PaymentDataRequest {

    private PaymentMethod paymentMethod;
    private Map<String, String> paymentMethodProperties;

    @Valid
    @NotNull
    private AddressRequest paymentAddress;
}
