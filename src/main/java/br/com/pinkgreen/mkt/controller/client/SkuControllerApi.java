package br.com.pinkgreen.mkt.controller.client;

import br.com.pinkgreen.mkt.controller.model.SkuByProductIdResponse;
import br.com.pinkgreen.mkt.controller.model.SkuResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("unused")
@RestController
public interface SkuControllerApi {

    @ApiOperation(value = "Procurando SKU por código")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<SkuResponse> findSku(@PathVariable String code);

    @ApiOperation(value = "Retorna todos SKUs")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<List<SkuResponse>> findAllSkus();

    @ApiOperation(value = "Procurando todos os SKUs de um produto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indica que a requisição foi bem sucedida!"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<List<SkuByProductIdResponse>> findAllSkuByProductId(@PathVariable Integer productId);
}
