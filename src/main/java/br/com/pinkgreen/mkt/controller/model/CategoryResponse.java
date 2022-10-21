package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.CategoryDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse implements Serializable {

    @ApiModelProperty(value = "ID da categoria", required = true, example = "1000258")
    private Integer id;

    @ApiModelProperty(value = "Nome da categoria", required = true, example = "Celulares e Smartphones")
    private String name;

    @ApiModelProperty(value = "Imagem da categoria", required = true, example = "https://imageDomain/path.extension")
    private String image;

    public static List<CategoryResponse> fromDomain(List<CategoryDomain> categories) {
        return categories.stream()
                .map(CategoryResponse::fromDomain)
                .collect(toList());
    }

    private static CategoryResponse fromDomain(CategoryDomain category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getImage()
        );
    }
}
