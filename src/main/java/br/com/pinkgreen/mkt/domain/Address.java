package br.com.pinkgreen.mkt.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Address {
    private String city;
    private String state;
    private String country;
    private String neighborhood;
    private String zip;
    private String number;
}