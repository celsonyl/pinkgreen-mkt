package br.com.pinkgreen.mkt.controller.client;

import br.com.pinkgreen.mkt.controller.model.*;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.domain.exception.InvalidCustomerIdException;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("unused")
@RestController
public interface FavoriteControllerApi {
    @ApiOperation(value = "Criação de produto favorito")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<Void> createFavoriteProduct(@PathVariable String userId, @PathVariable String skuCode, UriComponentsBuilder uriComponentsBuilder, HttpServletRequest request) throws InvalidCustomerIdException, DataIntegrityException;

    @ApiOperation(value = "Lista todos os produtos favoritos do usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indica que a requisição foi bem sucedida!"),
            @ApiResponse(code = 400, message = "Requisição mal formatada"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<List<SkuResponse>> getAllFavoriteProductsByUserId(@PathVariable String id, HttpServletRequest request) throws InvalidCustomerIdException;

    @ApiOperation(value = "Lista todos os produtos favoritos do usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indica que a requisição foi bem sucedida!"),
            @ApiResponse(code = 400, message = "Requisição mal formatada"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<Void> getFavoriteProductByCustomerId(@PathVariable String customerId, @PathVariable String skuCode, HttpServletRequest request) throws InvalidCustomerIdException;

    @ApiOperation(value = "Remove um produto favorito do usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indica que a requisição foi bem sucedida!"),
            @ApiResponse(code = 204, message = "Indica que a operação foi executada!"),
            @ApiResponse(code = 400, message = "Requisição mal formatada"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<Void> deleteFavoriteProductsByUserIdAndProductId(@PathVariable String userId, @PathVariable String skuCode, HttpServletRequest request) throws InvalidCustomerIdException;
}