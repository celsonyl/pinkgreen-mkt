package br.com.pinkgreen.mkt.controller.client;

import br.com.pinkgreen.mkt.controller.model.CategoryResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("unused")
@RestController
public interface CategoryControllerApi {

    @ApiOperation(value = "Lista todas Categorias")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indica que a requisição foi bem sucedida!"),
            @ApiResponse(code = 400, message = "Requisição mal formatada"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<List<CategoryResponse>> listCategories();

    @ApiOperation(value = "Procura uma Categoria por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indica que a requisição foi bem sucedida!"),
            @ApiResponse(code = 400, message = "Requisição mal formatada"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "Categoria não existe"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<CategoryResponse> findById(@PathVariable Integer id);
}
