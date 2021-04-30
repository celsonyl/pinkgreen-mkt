package br.com.pinkgreen.mkt.gateway.postgresql.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDatabase implements Serializable {

    private String sku;
    private String name;
    private Double price;
    private Integer quantity;
}
