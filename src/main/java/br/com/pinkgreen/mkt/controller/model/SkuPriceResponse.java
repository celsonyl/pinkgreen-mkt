package br.com.pinkgreen.mkt.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "Preço do SKU", required = true, example = "199.99")
    private Double listPrice;

    @PositiveOrZero
    @ApiModelProperty(value = "Preço do SKU na promoção", example = "59.99")
    private Double salePrice;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT-3")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @ApiModelProperty(value = "Data inicial da promoção")
    private Instant startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT-3")
    @ApiModelProperty(value = "Data final da promoção")
    private Instant endDate;
}
