package br.com.pinkgreen.mkt.domain;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class SkuPriceDomain {

    private Double listPrice;
    private Double salePrice;
    private Instant startDate;
    private Instant endDate;
}
