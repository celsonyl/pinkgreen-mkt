package br.com.pinkgreen.mkt.gateway.postgresql.model;

import br.com.pinkgreen.mkt.domain.AddressDomain;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ShippingDataDatabase {

    private Double freightPrice;
    private Integer deliveryDays;
    private AddressDomain address;
}
