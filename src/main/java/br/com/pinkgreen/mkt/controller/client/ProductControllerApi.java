package br.com.pinkgreen.mkt.controller.client;

import br.com.pinkgreen.mkt.controller.model.*;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.domain.exception.InvalidCustomerIdException;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("unused")
@RestController
public interface ProductControllerApi {

    @ApiOperation(value = "Procura um produto por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indica que a requisição foi bem sucedida!"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<ProductResponse> findById(@PathVariable Integer id);

    @ApiOperation(value = "Lista todos os produtos ativos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indica que a requisição foi bem sucedida!"),
            @ApiResponse(code = 400, message = "Requisição mal formatada"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<List<ProductResponse>> listProducts();

    @ApiOperation(value = "Consulta produto ativo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indica que a requisição foi bem sucedida"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<List<ProductResponse>> searchProduct(@RequestParam(value = "text", defaultValue = "") String text);

    @ApiOperation(value = "Lista todos os produtos ativos por ID de categoria")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indica que a requisição foi bem sucedida!"),
            @ApiResponse(code = 400, message = "Requisição mal formatada"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<List<ProductResponse>> findByCategoryId(@PathVariable Integer id);

    @ApiOperation(value = "Lista todos os produtos ativos pelo ID da Marca")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indica que a requisição foi bem sucedida!"),
            @ApiResponse(code = 400, message = "Requisição mal formatada"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<List<ProductResponse>> listProductsByBrandId(@PathVariable Integer id);

}