package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.CategoryControllerApi;
import br.com.pinkgreen.mkt.controller.model.CategoryRequest;
import br.com.pinkgreen.mkt.controller.model.CategoryResponse;
import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.translator.CategoryMapperImpl;
import br.com.pinkgreen.mkt.usecase.CreateCategoryUseCase;
import br.com.pinkgreen.mkt.usecase.GetAllCategoriesUseCase;
import br.com.pinkgreen.mkt.usecase.GetCategoryByIdUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController implements CategoryControllerApi {

    private final CreateCategoryUseCase productCategoryUseCase;
    private final GetAllCategoriesUseCase getAllCategoriesUseCase;
    private final GetCategoryByIdUseCase getCategoryByIdUseCase;

    @Override
    @PostMapping
    @RolesAllowed("admin")
    public ResponseEntity<Void> createCategory(CategoryRequest categoryRequest, UriComponentsBuilder uriComponentsBuilder) throws DataIntegrityException {
        var categoryDomain = new CategoryMapperImpl().categoryRequestToDomain(categoryRequest);

        var productCategoryDomain = productCategoryUseCase.execute(categoryDomain);

        var uri = uriComponentsBuilder.path("category/{id}").buildAndExpand(productCategoryDomain.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<CategoryResponse>> listCategories() {
        List<CategoryDomain> categoryDomainList = getAllCategoriesUseCase.listCategories();
        return ResponseEntity.ok().body(categoryDomainList.stream()
                .map(new CategoryMapperImpl()::categoryDomainToResponse)
                .collect(Collectors.toList()));
    }

    @Override
    @GetMapping(value = "/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<CategoryResponse> findById(Integer id) {
        var categoryDomain = getCategoryByIdUseCase.findById(id);
        return ResponseEntity.ok().body(new CategoryMapperImpl().categoryDomainToResponse(categoryDomain));
    }
}
