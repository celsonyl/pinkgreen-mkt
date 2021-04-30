package br.com.pinkgreen.mkt.gateway.postgresql.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CustomerDatabase {

    private String id;
    private String name;
    private String lastname;
    private String document;
    private String email;
    private String phone;
}
