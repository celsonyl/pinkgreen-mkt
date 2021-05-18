package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(example = "{\"cardNumber\": \"1111222233334444\"," +
            " \"cvv\": \"123\"," +
            " \"validationDate\": \"01/22\"," +
            " \"document\": \"497.229.723-46\"," +
            " \"ownerName\": \"Elza Luna Rocha\"," +
            " \"birthday\": \"21/05/2000\"," +
            " \"phone\": \"+55 (19) 99999-9999\"," +
            " \"email\": \"test@test.com.br\"}")
    private Map<String, String> paymentMethodProperties;

    @Valid
    @NotNull
    private AddressRequest paymentAddress;
}
