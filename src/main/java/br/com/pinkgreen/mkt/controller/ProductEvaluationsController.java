package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.model.ProductEvaluationBySkuResponse;
import br.com.pinkgreen.mkt.controller.client.ProductEvaluationsControllerApi;
import br.com.pinkgreen.mkt.controller.model.ProductEvaluationRequest;
import br.com.pinkgreen.mkt.controller.model.ProductEvaluationResponse;
import br.com.pinkgreen.mkt.domain.CustomerDomain;
import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.ProductEvaluationBySkuCode;
import br.com.pinkgreen.mkt.domain.ProductEvaluationDomain;
import br.com.pinkgreen.mkt.domain.exception.InvalidCustomerIdException;
import br.com.pinkgreen.mkt.exception.OrderNotFoundException;
import br.com.pinkgreen.mkt.exception.SkuNotContainedOnOrderException;
import br.com.pinkgreen.mkt.gateway.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static br.com.pinkgreen.mkt.controller.model.ProductEvaluationResponse.response;
import static br.com.pinkgreen.mkt.controller.util.VerifyCustomerId.getCustomerIdAndValidate;
import static br.com.pinkgreen.mkt.exception.SkuOrderEvaluationNotFoundException.evaluationNotFound;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/evaluations")
@RequiredArgsConstructor
public class ProductEvaluationsController implements ProductEvaluationsControllerApi {

    private final FindOrderById findOrderById;
    private final CreateProductEvaluationGateway createProductEvaluationGateway;
    private final GetProductEvaluationBySkuCode getProductEvaluationBySkuCode;
    private final GetProductEvaluationByOrderIdAndSkuCode getProductEvaluationByOrderIdAndSkuCode;
    private final FindCustomerById findCustomerById;
    private final GetProductEvaluationByCustomerId getProductEvaluationByCustomerId;
    private final GetProductEvaluationByOrderId getProductEvaluationByOrderId;

    @Override
    @PostMapping("/order/{orderId}/product/{skuCode}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> evaluate(
            Integer orderId,
            String skuCode,
            ProductEvaluationRequest body,
            HttpServletRequest request,
            UriComponentsBuilder uriComponentsBuilder
    ) throws InvalidCustomerIdException {
        OrderDomain order = findOrderById.execute(orderId).orElseThrow(OrderNotFoundException::new);

        getCustomerIdAndValidate((JwtAuthenticationToken) request.getUserPrincipal(), order.getCustomerData().getId());

        boolean containsSku = order.getProductList().stream().anyMatch(p -> p.getSkuCode().equals(skuCode));
        if (!containsSku) throw new SkuNotContainedOnOrderException(skuCode);

        var productEvaluationCreated = createProductEvaluationGateway.execute(
                body.domain(orderId, skuCode, order.getCustomerData().getId())
        );

        var uri = uriComponentsBuilder.path("/product/{SkuCode}").buildAndExpand(productEvaluationCreated.getSkuCode()).toUri();

        return created(uri).build();
    }

    @Override
    @GetMapping("/order/{orderId}/product/{skuCode}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<ProductEvaluationResponse> productOrderEvaluation(
            Integer orderId,
            String skuCode,
            HttpServletRequest request
    ) throws InvalidCustomerIdException {
        OrderDomain order = findOrderById.execute(orderId).orElseThrow(OrderNotFoundException::new);

        getCustomerIdAndValidate((JwtAuthenticationToken) request.getUserPrincipal(), order.getCustomerData().getId());

        boolean containsSku = order.getProductList().stream().anyMatch(p -> p.getSkuCode().equals(skuCode));
        if (!containsSku) throw new SkuNotContainedOnOrderException(skuCode);

        var evaluation = getProductEvaluationByOrderIdAndSkuCode.execute(orderId, skuCode)
                .map(it -> {
                    CustomerDomain customer = findCustomerById.execute(it.getCustomer().getId());
                    it.setCustomer(customer);
                    return it;
                })
                .map(ProductEvaluationResponse::response)
                .orElseThrow(evaluationNotFound(orderId, skuCode));

        return ok(evaluation);
    }

    @Override
    @GetMapping("/product/{skuCode}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<ProductEvaluationBySkuResponse> productEvaluations(String skuCode) {
        ProductEvaluationBySkuCode evaluations = getProductEvaluationBySkuCode.execute(skuCode);
        evaluations.getData().forEach(it -> {
            CustomerDomain customer = findCustomerById.execute(it.getCustomer().getId());
            it.setCustomer(customer);
        });
        return ok(ProductEvaluationBySkuResponse.response(evaluations));
    }

    @Override
    @GetMapping("/customer/{customerId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<ProductEvaluationResponse>> customerEvaluations(
            String customerId,
            HttpServletRequest request
    ) throws InvalidCustomerIdException {
        getCustomerIdAndValidate((JwtAuthenticationToken) request.getUserPrincipal(), customerId);
        List<ProductEvaluationDomain> evaluations = getProductEvaluationByCustomerId.execute(customerId);
        evaluations.forEach(it -> {
            CustomerDomain customer = findCustomerById.execute(it.getCustomer().getId());
            it.setCustomer(customer);
        });
        return ok(response(evaluations));
    }

    @Override
    @GetMapping("/order/{orderId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<ProductEvaluationResponse>> orderEvaluations(
            Integer orderId,
            HttpServletRequest request
    ) throws InvalidCustomerIdException {
        OrderDomain order = findOrderById.execute(orderId).orElseThrow(OrderNotFoundException::new);
        getCustomerIdAndValidate((JwtAuthenticationToken) request.getUserPrincipal(), order.getCustomerData().getId());
        List<ProductEvaluationDomain> evaluations = getProductEvaluationByOrderId.execute(orderId);
        evaluations.forEach(it -> {
            CustomerDomain customer = findCustomerById.execute(it.getCustomer().getId());
            it.setCustomer(customer);
        });
        return ok(response(evaluations));
    }
}
