package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.AddressDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AddressResponse implements Serializable {

    @ApiModelProperty(value = "Cidade de entrega", required = true, example = "Limeira")
    private String city;

    @ApiModelProperty(value = "Estado de entrega", required = true, example = "SP")
    private String state;

    @ApiModelProperty(value = "País de entrega", required = true, example = "Brasil")
    private String country;

    @ApiModelProperty(value = "Bairro de entrega", required = true, example = "Centro")
    private String neighborhood;

    @ApiModelProperty(value = "CEP de entrega", required = true, example = "13480-180")
    private String zipcode;

    @ApiModelProperty(value = "Rua de entrega", required = true, example = "R. Boa Morte")
    private String street;

    @ApiModelProperty(value = "Complemento do endereço", required = true, example = "AP 190")
    private String complement;

    @ApiModelProperty(value = "Complemento do endereço", required = true, example = "380")
    private String number;

    @ApiModelProperty(value = "Numero de contato", required = true, example = "+55 (19) 99999-9999")
    private String phone;

    public static AddressResponse fromDomain(AddressDomain address) {
        return new AddressResponse(
                address.getCity(),
                address.getState(),
                address.getCountry(),
                address.getNeighborhood(),
                address.getZipcode(),
                address.getStreet(),
                address.getComplement(),
                address.getNumber(),
                address.getPhone()
        );
    }
}