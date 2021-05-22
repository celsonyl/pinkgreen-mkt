package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.model.ProductCategoryRequest;
import br.com.pinkgreen.mkt.controller.translator.ProductCategoryRequestMapperImpl;
import br.com.pinkgreen.mkt.domain.ProductCategoryDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.ProductCategoryRepository;
import br.com.pinkgreen.mkt.usecase.CreateProductCategoryUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;

@Slf4j
@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog")
public class CatalogController implements CatalogControllerApi {

    private final CreateProductCategoryUseCase productCategoryUseCase;

    @Override
    @PostMapping(value = "/category/create")
    @RolesAllowed("admin")
    public ResponseEntity<Void> createCategory(@Valid @RequestBody ProductCategoryRequest productCategoryRequest) {
        var categoryDomain = new ProductCategoryRequestMapperImpl().categoryRequestToDomain(productCategoryRequest);

        ProductCategoryDomain productCategoryDomain = productCategoryUseCase.execute(categoryDomain);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productCategoryDomain.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
