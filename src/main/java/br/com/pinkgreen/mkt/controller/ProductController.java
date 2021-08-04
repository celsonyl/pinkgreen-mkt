package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.ProductControllerApi;
import br.com.pinkgreen.mkt.controller.model.ProductRequest;
import br.com.pinkgreen.mkt.controller.model.ProductResponse;
import br.com.pinkgreen.mkt.controller.model.ProductUpdateRequest;
import br.com.pinkgreen.mkt.controller.util.URL;
import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import br.com.pinkgreen.mkt.usecase.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/product")
public class ProductController implements ProductControllerApi {

    private final GetProductByIdUseCase getProductByIdUseCase;
    private final CreateProductUseCase createProductUseCase;
    private final GetAllProductsUseCase getAllProductsUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final GetProductByCategoryIdUseCase getProductByCategoryIdUseCase;

    @Override
    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<ProductResponse> findById(Integer id) {
        var productDomain = getProductByIdUseCase.findById(id);
        return ResponseEntity.ok().body(new ProductMapperImpl().productDomainToResponse(productDomain));
    }

    @Override
    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<ProductResponse>> listProducts() {
        var productsDomain = getAllProductsUseCase.execute();
        return ResponseEntity.ok().body(productsDomain.stream()
                .map(new ProductMapperImpl()::productDomainToResponse)
                .collect(Collectors.toList()));
    }

    @Override
    @GetMapping("/search")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<ProductResponse>> searchProduct(String text) {
        text = URL.decodeParam(text);
        List<ProductDomain> searchProduct = getAllProductsUseCase.searchProduct(text);
        return ResponseEntity.ok(searchProduct.stream()
                .map(new ProductMapperImpl()::productDomainToResponse)
                .collect(Collectors.toList()));
    }

    @Override
    @GetMapping("/category/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<ProductResponse>> findByCategoryId(Integer id) {
        var products = getProductByCategoryIdUseCase.execute(id);
        return ResponseEntity.ok(products.stream()
                .map(new ProductMapperImpl()::productDomainToResponse)
                .collect(Collectors.toList()));
    }

    @Override
    @PostMapping
    @RolesAllowed("admin")
    public ResponseEntity<Void> createProduct(ProductRequest productRequest, UriComponentsBuilder uriComponentsBuilder) {
        var productDomain = new ProductMapperImpl().productRequestToDomain(productRequest);

        var productCreateDomain = createProductUseCase.execute(productDomain);
        var uri = uriComponentsBuilder.path("product/{id}").buildAndExpand(productCreateDomain.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @Override
    @PutMapping("/{id}")
    @RolesAllowed("admin")
    public ResponseEntity<Void> updateProduct(Integer id, ProductUpdateRequest productUpdateRequest) {
        var productDomain = new ProductMapperImpl().productUpdateRequestToDomain(productUpdateRequest);

        updateProductUseCase.updateProduct(id, productDomain);
        return ResponseEntity.noContent().build();
    }
}
