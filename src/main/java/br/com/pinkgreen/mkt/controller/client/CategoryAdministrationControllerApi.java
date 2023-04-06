package br.com.pinkgreen.mkt.controller.client;

import br.com.pinkgreen.mkt.controller.model.CategoryRequest;
import br.com.pinkgreen.mkt.controller.model.CategoryResponse;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("unused")
@RestController
public interface CategoryAdministrationControllerApi {

    @ApiOperation(value = "Cria uma Categoria de Produto")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Requisição mal formatada"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<Void> createCategory(@Valid @RequestBody CategoryRequest categoryRequest, UriComponentsBuilder uriComponentsBuilder) throws DataIntegrityException;

    @ApiOperation(value = "Deleta uma Categoria por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indica que a requisição foi bem sucedida!"),
            @ApiResponse(code = 400, message = "Requisição mal formatada"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "Categoria não existe"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<Void> deleteById(@PathVariable Integer id);
}
