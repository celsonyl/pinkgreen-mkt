package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.ProductControllerApi;
import br.com.pinkgreen.mkt.controller.model.ProductRequest;
import br.com.pinkgreen.mkt.controller.model.ProductResponse;
import br.com.pinkgreen.mkt.controller.model.ProductUpdateRequest;
import br.com.pinkgreen.mkt.controller.util.URL;
import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.domain.exception.InvalidCustomerIdException;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import br.com.pinkgreen.mkt.usecase.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/product")
public class ProductController implements ProductControllerApi {

    private final GetEnabledProductByIdUseCase getEnabledProductByIdUseCase;
    private final CreateProductUseCase createProductUseCase;
    private final GetAllEnabledProductsUseCase getAllEnabledProductsUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final GetEnabledProductByCategoryIdUseCase getEnabledProductByCategoryIdUseCase;
    private final GetAllEnabledProductsByBrandIdUseCase getAllEnabledProductsByBrandIdUseCase;
    private final SearchEnabledProductsByTextUseCase searchEnabledProductsByTextUseCase;
    private final GetAllFavoriteProductsByUserIdUseCase getAllFavoriteProductsByUserIdUseCase;
    private final DeleteFavoriteProductByUserIdAndProductIdUserCase deleteFavoriteProductByUserIdAndProductIdUserCase;

    @Override
    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<ProductResponse> findById(Integer id) {
        var productDomain = getEnabledProductByIdUseCase.findById(id);
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

    @Override
    @PostMapping
    public ResponseEntity<Void> createProduct(ProductRequest productRequest, UriComponentsBuilder uriComponentsBuilder) {
        var productDomain = new ProductMapperImpl().productRequestToDomain(productRequest);

        var productCreateDomain = createProductUseCase.execute(productDomain);
        var uri = uriComponentsBuilder.path("product/{id}").buildAndExpand(productCreateDomain.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(Integer id, ProductUpdateRequest productUpdateRequest) {
        var productDomain = new ProductMapperImpl().productUpdateRequestToDomain(productUpdateRequest);

        updateProductUseCase.updateProduct(id, productDomain);
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping("/favorite_products/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<ProductResponse>> getAllFavoriteProductsByUserId(String id, HttpServletRequest request) throws InvalidCustomerIdException {
        getCustomerIdAndValidate((JwtAuthenticationToken) request.getUserPrincipal(), id);

        var productsDomain = getAllFavoriteProductsByUserIdUseCase.execute(id);
        return ResponseEntity.ok().body(productsDomain.stream()
                .map(new ProductMapperImpl()::productDomainToResponse)
                .collect(Collectors.toList()));
    }

    @Override
    @DeleteMapping("/favorite_products/{productId}/user/{userId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> deleteFavoriteProductsByUserIdAndProductId(String userId, Integer productId, HttpServletRequest request) throws InvalidCustomerIdException {
        getCustomerIdAndValidate((JwtAuthenticationToken) request.getUserPrincipal(), userId);

        deleteFavoriteProductByUserIdAndProductIdUserCase.execute(userId, productId);
        return ResponseEntity.noContent().build();
    }

    private void getCustomerIdAndValidate(JwtAuthenticationToken authenticationToken, String customerId) throws InvalidCustomerIdException {
        String tokenCustomerId = authenticationToken.getToken().getSubject();

        if (!customerId.equals(tokenCustomerId)) {
            throw new InvalidCustomerIdException("[CONTROLLER] Invalid customerId");
        }
    }
}