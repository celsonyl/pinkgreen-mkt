package br.com.pinkgreen.mkt.gateway.postgresql.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "product_brand")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BrandDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
