package br.com.pinkgreen.mkt.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CustomerResponse implements Serializable {


    @ApiModelProperty(value = "ID do cliente", required = true, example = "1f508dc081fd6db15d1d9056e457cd3f")
    private String id;

    @ApiModelProperty(value = "Primeiro nome do cliente", required = true, example = "Elza")
    private String name;

    @ApiModelProperty(value = "Sobrenome do cliente", required = true, example = "Luna Rocha")
    private String lastname;

    @ApiModelProperty(value = "CPF do cliente", required = true, example = "947.229.723-46")
    private String document;

    @ApiModelProperty(value = "E-mail do cliente", required = true, example = "test@test.com.br")
    private String email;

    @ApiModelProperty(value = "Número de telefone do cliente", required = true, example = "+55 (19) 99999-9999")
    private String phone;
}
