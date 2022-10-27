package br.com.pinkgreen.mkt.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CustomerDomain implements Serializable {

    private String id;
    private String name;
    private String lastname;
    private String document;
    private String email;
    private String phone;

    public CustomerDomain(String id) {
        this.id = id;
    }
}
