package br.com.pinkgreen.mkt.domain;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class SkuPriceDomain implements Serializable {

    private static final Instant NOW = Instant.now();

    private Double listPrice;
    private Double salePrice;
    private Instant startDate = NOW;
    private Instant endDate = NOW;

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
