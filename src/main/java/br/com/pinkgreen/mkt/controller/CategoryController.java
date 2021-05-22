package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.model.ProductCategoryRequest;
import br.com.pinkgreen.mkt.controller.translator.ProductCategoryRequestMapperImpl;
import br.com.pinkgreen.mkt.domain.ProductCategoryDomain;
import br.com.pinkgreen.mkt.usecase.CreateProductCategoryUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.net.URI;

@Slf4j
@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController implements CategoryControllerApi {

    private final CreateProductCategoryUseCase productCategoryUseCase;

    @Override
    @PostMapping(value = "/create")
    @RolesAllowed("admin")
    public ResponseEntity<Void> createCategory(@Valid @RequestBody ProductCategoryRequest productCategoryRequest) {
        var categoryDomain = new ProductCategoryRequestMapperImpl().categoryRequestToDomain(productCategoryRequest);

        ProductCategoryDomain productCategoryDomain = productCategoryUseCase.execute(categoryDomain);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productCategoryDomain.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
