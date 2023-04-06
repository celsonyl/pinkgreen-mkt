package br.com.pinkgreen.mkt.controller.client;

import br.com.pinkgreen.mkt.controller.model.ProductRequest;
import br.com.pinkgreen.mkt.controller.model.ProductResponse;
import br.com.pinkgreen.mkt.controller.model.ProductUpdateRequest;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("unused")
@RestController
public interface ProductAdministrationControllerApi {

    @ApiOperation(value = "Criação de produto")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<Void> createProduct(@Valid @RequestBody ProductRequest productRequest, UriComponentsBuilder uriComponentsBuilder);

    @ApiOperation(value = "Atualizar produto")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<Void> updateProduct(@PathVariable Integer id, @Valid @RequestBody ProductUpdateRequest productUpdateRequest);

    @ApiOperation(value = "Deleta produto por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indica que a requisição foi bem sucedida!"),
            @ApiResponse(code = 400, message = "Requisição mal formatada"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<Void> deleteProductById(@PathVariable Integer id);


    @ApiOperation(value = "Lista todos os produtos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indica que a requisição foi bem sucedida!"),
            @ApiResponse(code = 400, message = "Requisição mal formatada"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<List<ProductResponse>> listProducts();

}