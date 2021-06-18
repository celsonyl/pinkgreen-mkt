package br.com.pinkgreen.mkt.domain;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class SkuPriceDomain implements Serializable {

    private Double listPrice;
    private Double salePrice;
    private Instant startDate = Instant.MIN;
    private Instant endDate = Instant.MIN;

    public SkuPriceDomain(Double listPrice, Double salePrice, Instant startDate, Instant endDate) {
        this.listPrice = listPrice;
        this.salePrice = salePrice;

        if (startDate != null) {
            this.startDate = startDate;
        }
        if (endDate != null) {
            this.endDate = endDate;
        }
    }
}
