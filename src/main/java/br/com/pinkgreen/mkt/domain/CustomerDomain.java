package br.com.pinkgreen.mkt.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CustomerDomain {

    private String id;
    private String name;
    private String lastname;
    private String document;
    private String email;
    private String phone;
}
