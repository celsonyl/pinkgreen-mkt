package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.CheckoutOrderProductData;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class ProductOrderRequest implements Serializable {

    @NotBlank
    @Length(min = 2, max = 200, message = "Name must have between 2 and 200 characters")
    @ApiModelProperty(value = "Cod do Sku", required = true, example = "CELPHX06")
    private String skuCode;

    @NotNull(message = "Price must not be null")
    @ApiModelProperty(value = "Preço do produto", required = true, example = "3859.90")
    private SkuPriceRequest price;

    @NotNull(message = "Product quantities must not be null")
    @PositiveOrZero
    @ApiModelProperty(value = "Quantidade de itens deste produto", required = true, example = "2")
    private Integer quantity;

    public CheckoutOrderProductData toDomain() {
        return new CheckoutOrderProductData(
                skuCode,
                price.toDomain(),
                quantity
        );
    }

    public static List<CheckoutOrderProductData> toDomain(List<ProductOrderRequest> productList) {
        return productList.stream()
                .map(ProductOrderRequest::toDomain)
                .collect(toList());
    }
}
