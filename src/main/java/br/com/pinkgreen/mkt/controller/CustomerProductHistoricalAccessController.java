package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.CustomerProductHistoricalAccessControllerApi;
import br.com.pinkgreen.mkt.controller.model.ProductResponse;
import br.com.pinkgreen.mkt.gateway.GetProductAccessHistoricalByCustomerIdGateway;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@Component
@RequiredArgsConstructor
@RequestMapping("/customer-product-access-historical")
public class CustomerProductHistoricalAccessController implements CustomerProductHistoricalAccessControllerApi {

    private final GetProductAccessHistoricalByCustomerIdGateway getProductAccessHistoricalByCustomerId;

    @Override
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{customerId}")
    public ResponseEntity<List<ProductResponse>> getProdutHistoricalAccess(String customerId) {
        return ok(getProductAccessHistoricalByCustomerId.execute(customerId).stream()
                .map(new ProductMapperImpl()::productDomainToResponse)
                .collect(toList()));
    }
}
