package br.com.pinkgreen.mkt.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AddressDomain implements Serializable {

    private String city;
    private String state;
    private String country;
    private String neighborhood;
    private String street;
    private String zipcode;
    private String complement;
    private String number;
    private String phone;
}