package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.ProductAdministrationControllerApi;
import br.com.pinkgreen.mkt.controller.model.ProductRequest;
import br.com.pinkgreen.mkt.controller.model.ProductResponse;
import br.com.pinkgreen.mkt.controller.model.ProductUpdateRequest;
import br.com.pinkgreen.mkt.gateway.DeleteProductByIdGateway;
import br.com.pinkgreen.mkt.gateway.FindAllProductsGateway;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import br.com.pinkgreen.mkt.usecase.CreateProductUseCase;
import br.com.pinkgreen.mkt.usecase.UpdateProductUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@Component
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/product-administration")
public class ProductAdministrationController implements ProductAdministrationControllerApi {

    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductByIdGateway deleteProductById;
    private final FindAllProductsGateway findAllProducts;

    @Override
    @PostMapping("/product")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> createProduct(ProductRequest productRequest, UriComponentsBuilder uriComponentsBuilder) {
        var productDomain = new ProductMapperImpl().productRequestToDomain(productRequest);

        var productCreateDomain = createProductUseCase.execute(productDomain);
        var uri = uriComponentsBuilder.path("product/{id}").buildAndExpand(productCreateDomain.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @Override
    @PutMapping("/product/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> updateProduct(Integer id, ProductUpdateRequest productUpdateRequest) {
        var productDomain = new ProductMapperImpl().productUpdateRequestToDomain(productUpdateRequest);

        updateProductUseCase.updateProduct(id, productDomain);
        return noContent().build();
    }

    @Override
    @DeleteMapping("/product/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> deleteProductById(Integer id) {
        deleteProductById.execute(id);
        return noContent().build();
    }

    @Override
    @GetMapping("/product")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<ProductResponse>> listProducts() {
        List<ProductResponse> products = findAllProducts.execute().stream()
                .map(it -> new ProductMapperImpl().productDomainToResponse(it))
                .collect(toList());
        return ok(products);
    }
}
