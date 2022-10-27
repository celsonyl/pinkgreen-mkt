package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.ProductEvaluationsControllerApi;
import br.com.pinkgreen.mkt.controller.model.ProductEvaluationRequest;
import br.com.pinkgreen.mkt.controller.model.ProductEvaluationResponse;
import br.com.pinkgreen.mkt.domain.CustomerDomain;
import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.ProductEvaluationDomain;
import br.com.pinkgreen.mkt.domain.exception.InvalidCustomerIdException;
import br.com.pinkgreen.mkt.exception.OrderNotFoundException;
import br.com.pinkgreen.mkt.exception.SkuNotContainedOnOrderException;
import br.com.pinkgreen.mkt.gateway.CreateProductEvaluationGateway;
import br.com.pinkgreen.mkt.gateway.FindCustomerById;
import br.com.pinkgreen.mkt.gateway.FindOrderById;
import br.com.pinkgreen.mkt.gateway.GetProductEvaluationBySkuCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static br.com.pinkgreen.mkt.controller.model.ProductEvaluationResponse.response;
import static br.com.pinkgreen.mkt.controller.util.VerifyCustomerId.getCustomerIdAndValidate;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/evaluations")
@RequiredArgsConstructor
public class ProductEvaluationsController implements ProductEvaluationsControllerApi {

    private final FindOrderById findOrderById;
    private final CreateProductEvaluationGateway createProductEvaluationGateway;
    private final GetProductEvaluationBySkuCode getProductEvaluationBySkuCode;
    private final FindCustomerById findCustomerById;

    @Override
    @PostMapping("/order/{orderId}/product/{skuCode}")
    public ResponseEntity<Void> evaluate(Integer orderId, String skuCode, ProductEvaluationRequest body, HttpServletRequest request, UriComponentsBuilder uriComponentsBuilder) throws InvalidCustomerIdException {
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
    @GetMapping("/product/{skuCode}")
    public ResponseEntity<List<ProductEvaluationResponse>> productEvaluations(String skuCode) {
        List<ProductEvaluationDomain> evaluations = getProductEvaluationBySkuCode.execute(skuCode);
        evaluations.forEach(it -> {
            CustomerDomain customer = findCustomerById.execute(it.getCustomer().getId());
            it.setCustomer(customer);
        });
        return ok(response(evaluations));
    }

    @Override
    public ResponseEntity<List<ProductEvaluationResponse>> customerEvaluations(String customerId, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductEvaluationResponse>> orderEvaluations(Integer orderId, HttpServletRequest request) {
        return null;
    }
}
