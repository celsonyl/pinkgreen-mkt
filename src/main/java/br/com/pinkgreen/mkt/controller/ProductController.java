package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.model.ProductRequest;
import br.com.pinkgreen.mkt.controller.model.ProductResponse;
import br.com.pinkgreen.mkt.controller.model.ProductUpdateRequest;
import br.com.pinkgreen.mkt.translator.ProductMapperImpl;
import br.com.pinkgreen.mkt.usecase.CreateProductUseCase;
import br.com.pinkgreen.mkt.usecase.GetAllProductsUseCase;
import br.com.pinkgreen.mkt.usecase.GetProductByIdUseCase;
import br.com.pinkgreen.mkt.usecase.UpdateProductUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Component
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/product")
public class ProductController implements ProductControllerApi {

    private final GetProductByIdUseCase getProductByIdUseCase;
    private final CreateProductUseCase createProductUseCase;
    private final GetAllProductsUseCase getAllProductsUseCase;
    private final UpdateProductUseCase updateProductUseCase;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Integer id) {
        var productDomain = getProductByIdUseCase.findById(id);
        return ResponseEntity.ok().body(new ProductMapperImpl().productDomainToResponse(productDomain));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ProductResponse>> listProducts() {
        var productsDomain = getAllProductsUseCase.execute();
        return ResponseEntity.ok().body(productsDomain.stream()
                .map(new ProductMapperImpl()::productDomainToResponse)
                .collect(Collectors.toList()));
    }

    @Override
    @PostMapping
    @RolesAllowed("admin")
    public ResponseEntity<Void> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        var productDomain = new ProductMapperImpl().productRequestToDomain(productRequest);

        var productCreateDomain = createProductUseCase.execute(productDomain);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productCreateDomain.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @Override
    @PutMapping("/{id}")
    @RolesAllowed("admin")
    public ResponseEntity<Void> updateProduct(@Valid @RequestBody ProductUpdateRequest productUpdateRequest, @PathVariable Integer id) {
        var productUpdate = getProductByIdUseCase.findById(id);
        var productDomain = new ProductMapperImpl().productUpdateRequestToDomain(productUpdateRequest);
        productDomain.setId(id);
        productDomain.setBrand(productUpdate.getBrand());
        productDomain.setCategories(productUpdate.getCategories());

        updateProductUseCase.updateProduct(productDomain);
        return ResponseEntity.noContent().build();
    }
}
