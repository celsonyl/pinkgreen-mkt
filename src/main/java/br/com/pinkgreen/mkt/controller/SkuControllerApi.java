package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.model.SkuByProductIdResponse;
import br.com.pinkgreen.mkt.controller.model.SkuRequest;
import br.com.pinkgreen.mkt.controller.model.SkuResponse;
import br.com.pinkgreen.mkt.controller.model.SkuUpdateRequest;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("unused")
@RestController
public interface SkuControllerApi {

    @ApiOperation(value = "Criação de SKU")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "SKU Criado"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<Void> createSku(@Valid @RequestBody SkuRequest skuRequest) throws DataIntegrityException;

    @ApiOperation(value = "Procurando SKU by code")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "SKU Criado"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<SkuResponse> findSku(@PathVariable String code);

    @ApiOperation(value = "Atualizar SKU por code")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "SKU Criado"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<Void> updateSku(@PathVariable String code, @Valid @RequestBody SkuUpdateRequest skuUpdateRequest);

    @ApiOperation(value = "Procurando todos os SKUs de um produto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<List<SkuByProductIdResponse>> findAllSkuByProductId(@PathVariable Integer productId);
}
