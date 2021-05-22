package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.model.ProductCategoryRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface CatalogControllerApi {

    @ApiOperation(value = "Criar Categoria de Produto")
    @SuppressWarnings("unused")
    ResponseEntity<Void> createCategory(@Valid @RequestBody ProductCategoryRequest productCategoryRequest);
}
