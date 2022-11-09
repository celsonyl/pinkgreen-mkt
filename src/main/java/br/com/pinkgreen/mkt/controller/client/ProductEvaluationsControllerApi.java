package br.com.pinkgreen.mkt.controller.client;

import br.com.pinkgreen.mkt.controller.model.ProductEvaluationBySkuResponse;
import br.com.pinkgreen.mkt.controller.model.ProductEvaluationRequest;
import br.com.pinkgreen.mkt.controller.model.ProductEvaluationResponse;
import br.com.pinkgreen.mkt.domain.exception.InvalidCustomerIdException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
public interface ProductEvaluationsControllerApi {

    @ApiOperation(value = "Avaliar um produto de uma compra")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Indica que a avaliação foi criada com sucesso!"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<Void> evaluate(
            @PathVariable Integer orderId,
            @PathVariable String skuCode,
            @RequestBody @Valid ProductEvaluationRequest body,
            HttpServletRequest request,
            UriComponentsBuilder uriComponentsBuilder
    ) throws InvalidCustomerIdException;

    @ApiOperation(value = "Avaliação de um produto em um pedido")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Indica que a avaliação foi retornada com sucesso!"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<ProductEvaluationResponse> productOrderEvaluation(
            @PathVariable Integer orderId,
            @PathVariable String skuCode,
            HttpServletRequest request
    ) throws InvalidCustomerIdException;

    @ApiOperation(value = "Consulta todas as avalições de um produto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Avaliações retornadas com sucesso!"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<ProductEvaluationBySkuResponse> productEvaluations(
            @PathVariable String skuCode
    );

    @ApiOperation(value = "Consulta as avalições de um usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Avaliações retornadas com sucesso!"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<List<ProductEvaluationResponse>> customerEvaluations(
            @PathVariable String customerId,
            HttpServletRequest request
    ) throws InvalidCustomerIdException;

    @ApiOperation(value = "Consulta as avalições de um pedido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Avaliações retornadas com sucesso!"),
            @ApiResponse(code = 401, message = "Você não possui credenciais válidas para acessar este recurso, portanto será necessário autenticar-se novamente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 422, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro de servidor"),
    })
    ResponseEntity<List<ProductEvaluationResponse>> orderEvaluations(
            @PathVariable Integer orderId,
            HttpServletRequest request
    ) throws InvalidCustomerIdException;
}