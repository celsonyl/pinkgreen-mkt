package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.model.CategoryRequest;
import br.com.pinkgreen.mkt.controller.translator.ProductCategoryRequestMapperImpl;
import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.usecase.CreateProductCategoryUseCase;
import br.com.pinkgreen.mkt.usecase.GetAllCategoriesUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Slf4j
@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController implements CategoryControllerApi {

    private final CreateProductCategoryUseCase productCategoryUseCase;
    private final GetAllCategoriesUseCase getAllCategoriesUseCase;

    @Override
    @PostMapping
    public ResponseEntity<Void> createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        var categoryDomain = new ProductCategoryRequestMapperImpl().categoryRequestToDomain(categoryRequest);

        CategoryDomain productCategoryDomain = productCategoryUseCase.execute(categoryDomain);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productCategoryDomain.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CategoryRequest>> listCategories(){
        List<CategoryRequest> categoryRequestList = getAllCategoriesUseCase.listCategories();
        return ResponseEntity.ok().body(categoryRequestList);
    }
}
