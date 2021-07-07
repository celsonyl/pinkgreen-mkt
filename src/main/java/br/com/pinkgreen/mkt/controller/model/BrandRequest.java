package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.controller.annotation.BrandInsertData;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@BrandInsertData
public class BrandRequest implements Serializable {

    @ApiModelProperty(value = "ID da marca", required = true, example = "1000258")
    private Integer id;

    @NotBlank(message = "Field not be null or blank")
    @Length(min = 2, max = 50, message = "Name must have between 2 and 50 characters")
    @ApiModelProperty(value = "Nome da marca", required = true, example = "Samsung")
    private String name;
}
