package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.CategoryAdministrationControllerApi;
import br.com.pinkgreen.mkt.controller.model.CategoryRequest;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.gateway.DeleteCategoryByIdGateway;
import br.com.pinkgreen.mkt.gateway.UpdateCategoryByIdGateway;
import br.com.pinkgreen.mkt.translator.CategoryMapperImpl;
import br.com.pinkgreen.mkt.usecase.CreateCategoryUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.ResponseEntity.noContent;

@Slf4j
@Component
@RequiredArgsConstructor
@RequestMapping("/category-administration")
public class CategoryAdministrationController implements CategoryAdministrationControllerApi {

    private final CreateCategoryUseCase productCategoryUseCase;
    private final DeleteCategoryByIdGateway deleteCategoryById;
    private final UpdateCategoryByIdGateway updateCategoryById;

    @Override
    @PostMapping("/category")
    @CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "Location")
    public ResponseEntity<Void> createCategory(CategoryRequest categoryRequest, UriComponentsBuilder uriComponentsBuilder) throws DataIntegrityException {
        var categoryDomain = new CategoryMapperImpl().categoryRequestToDomain(categoryRequest);

        var productCategoryDomain = productCategoryUseCase.execute(categoryDomain);

        var uri = uriComponentsBuilder.path("category/{id}").buildAndExpand(productCategoryDomain.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    @DeleteMapping(value = "/category/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> deleteById(Integer id) {
        deleteCategoryById.execute(id);
        return noContent().build();
    }

    @Override
    @PutMapping(value = "/category/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> updateById(Integer id, CategoryRequest categoryRequest) {
        updateCategoryById.execute(id, new CategoryMapperImpl().categoryRequestToDomain(categoryRequest));
        return noContent().build();
    }
}
