package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.CustomerIntentionsControllerApi;
import br.com.pinkgreen.mkt.controller.model.ProductResponse;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import br.com.pinkgreen.mkt.usecase.GetProductsFromCustomerIntentions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@Component
@RequiredArgsConstructor
@RequestMapping("/customer-intentions")
public class CustomerIntentionsController implements CustomerIntentionsControllerApi {

    private final GetProductsFromCustomerIntentions getProductsFromCustomerIntentions;

    @Override
    @GetMapping("/{customerId}")
    public ResponseEntity<List<ProductResponse>> getProdutIntention(String customerId) {
        return ok(getProductsFromCustomerIntentions.execute(customerId).stream()
                .map(new ProductMapperImpl()::productDomainToResponse)
                .collect(toList()));
    }
}
