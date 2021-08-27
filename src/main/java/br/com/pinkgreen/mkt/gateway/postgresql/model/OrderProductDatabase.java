package br.com.pinkgreen.mkt.gateway.postgresql.model;

import br.com.pinkgreen.mkt.domain.SkuPriceDomain;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderProductDatabase implements Serializable {

    private String skuCode;
    private String name;
    private SkuPriceDomain price;
    private Integer stockQuantity;
    private Integer quantity;
}
