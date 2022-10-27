package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.ProductEvaluationsControllerApi;
import br.com.pinkgreen.mkt.controller.model.ProductEvaluationRequest;
import br.com.pinkgreen.mkt.controller.model.ProductEvaluationResponse;
import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.exception.InvalidCustomerIdException;
import br.com.pinkgreen.mkt.exception.OrderNotFoundException;
import br.com.pinkgreen.mkt.exception.SkuNotContainedOnOrderException;
import br.com.pinkgreen.mkt.gateway.CreateProductEvaluationGateway;
import br.com.pinkgreen.mkt.gateway.FindOrderById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/evaluations")
@RequiredArgsConstructor
public class ProductEvaluationsController implements ProductEvaluationsControllerApi {

    private final FindOrderById findOrderById;
    private final CreateProductEvaluationGateway createProductEvaluationGateway;

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

        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<List<ProductEvaluationResponse>> productEvaluations(String skuCode) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductEvaluationResponse>> customerEvaluations(String customerId, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductEvaluationResponse>> orderEvaluations(Integer orderId, HttpServletRequest request) {
        return null;
    }


    private void getCustomerIdAndValidate(JwtAuthenticationToken authenticationToken, String customerId) throws InvalidCustomerIdException {
        String tokenCustomerId = authenticationToken.getToken().getSubject();

        if (!customerId.equals(tokenCustomerId)) {
            throw new InvalidCustomerIdException("[CONTROLLER] Invalid customerId");
        }
    }
}
