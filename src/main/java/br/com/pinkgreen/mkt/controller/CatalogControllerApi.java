package br.com.pinkgreen.mkt.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

public interface CatalogControllerApi {

    @ApiOperation(value = "")
    ResponseEntity createCategory();
}
