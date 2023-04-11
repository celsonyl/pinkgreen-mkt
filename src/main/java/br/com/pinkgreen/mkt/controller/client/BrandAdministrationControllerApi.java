package br.com.pinkgreen.mkt.controller.client;

import br.com.pinkgreen.mkt.controller.model.BrandRequest;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.exception.BrandIsNotAbleToBeDeletedException;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@SuppressWarnings("unused")
@RestController
public interface BrandAdministrationControllerApi {

    @ApiOperation(value = "Criar marca de Produto")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<Void> createBrand(@Valid @RequestBody BrandRequest brandRequest, UriComponentsBuilder uriComponentsBuilder) throws DataIntegrityException;

    @ApiOperation(value = "Deleta marca por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indica que a requisição foi bem sucedida"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<Void> deleteById(@PathVariable Integer id) throws BrandIsNotAbleToBeDeletedException;

    @ApiOperation(value = "Atualiza marca por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indica que a requisição foi bem sucedida"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<Void> updateById(@PathVariable Integer id, @Valid @RequestBody BrandRequest brandRequest);
}
