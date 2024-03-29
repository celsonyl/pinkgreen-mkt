package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.ProductControllerApi;
import br.com.pinkgreen.mkt.controller.model.ProductResponse;
import br.com.pinkgreen.mkt.controller.util.URL;
import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import br.com.pinkgreen.mkt.usecase.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.pinkgreen.mkt.controller.util.VerifyCustomerId.getCustomerIdAndValidate;
import static org.springframework.http.ResponseEntity.status;

@Component
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/product")
public class ProductController implements ProductControllerApi {

    private final GetEnabledProductByIdUseCase getEnabledProductByIdUseCase;
    private final GetAllEnabledProductsUseCase getAllEnabledProductsUseCase;
    private final GetEnabledProductByCategoryIdUseCase getEnabledProductByCategoryIdUseCase;
    private final GetAllEnabledProductsByBrandIdUseCase getAllEnabledProductsByBrandIdUseCase;
    private final SearchEnabledProductsByTextUseCase searchEnabledProductsByTextUseCase;

    @SneakyThrows
    @Override
    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = {"*"})
    public ResponseEntity<ProductResponse> findById(Integer id, String customerId, HttpServletRequest request) {
        JwtAuthenticationToken userPrincipal = (JwtAuthenticationToken) request.getUserPrincipal();
        if (customerId != null && userPrincipal == null) return status(HttpStatus.UNAUTHORIZED).build();
        if (customerId != null) getCustomerIdAndValidate(userPrincipal, customerId);
        var productDomain = getEnabledProductByIdUseCase.findById(id, customerId);
        return ResponseEntity.ok().body(new ProductMapperImpl().productDomainToResponse(productDomain));
    }

    @Override
    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<ProductResponse>> listProducts() {
        var productsDomain = getAllEnabledProductsUseCase.execute();
        return ResponseEntity.ok().body(productsDomain.stream()
                .map(new ProductMapperImpl()::productDomainToResponse)
                .collect(Collectors.toList()));
    }

    @Override
    @GetMapping("/search")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<ProductResponse>> searchProduct(String text) {
        text = URL.decodeParam(text);
        List<ProductDomain> searchProduct = searchEnabledProductsByTextUseCase.searchProduct(text);
        return ResponseEntity.ok(searchProduct.stream()
                .map(new ProductMapperImpl()::productDomainToResponse)
                .collect(Collectors.toList()));
    }

    @Override
    @GetMapping("/category/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<ProductResponse>> findByCategoryId(Integer id) {
        var products = getEnabledProductByCategoryIdUseCase.execute(id);
        return ResponseEntity.ok(products.stream()
                .map(new ProductMapperImpl()::productDomainToResponse)
                .collect(Collectors.toList()));
    }

    @Override
    @GetMapping("/brand/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<ProductResponse>> listProductsByBrandId(Integer id) {
        var productsDomain = getAllEnabledProductsByBrandIdUseCase.execute(id);
        return ResponseEntity.ok().body(productsDomain.stream()
                .map(new ProductMapperImpl()::productDomainToResponse)
                .collect(Collectors.toList()));
    }
}