package br.com.pinkgreen.mkt.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

import static java.time.Instant.now;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class SkuPriceDomain implements Serializable {
    private Double listPrice;
    private Double salePrice;
    private Instant startDate;
    private Instant endDate;

    public SkuPriceDomain(Double listPrice, Double salePrice, Instant startDate, Instant endDate) {
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Double getActivePrice() {
        var now = now();
        if (now.isBefore(getEndDate()) && now.isAfter(getStartDate())) return getSalePrice();
        return getListPrice();
    }
}
