package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.FavoriteProductDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class FavoriteProductRequest implements Serializable {

    @NotNull(message = "Product Sku ID not be null")
    @ApiModelProperty(value = "ID do SKU", required = true, example = "XPTO_SKU")
    private String skuCode;

    public FavoriteProductDomain domain(String userId) {
        return new FavoriteProductDomain(userId, skuCode);
    }
}
