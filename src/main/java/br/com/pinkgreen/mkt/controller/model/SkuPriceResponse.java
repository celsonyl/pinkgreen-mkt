package br.com.pinkgreen.mkt.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SkuPriceResponse implements Serializable {

    @PositiveOrZero
    private Double listPrice;
    @PositiveOrZero
    private Double salePrice;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT-3")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Instant startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT-3")
    private Instant endDate;
}
