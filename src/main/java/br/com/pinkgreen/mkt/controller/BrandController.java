package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.model.BrandRequest;
import br.com.pinkgreen.mkt.controller.translator.BrandRequestMapperImpl;
import br.com.pinkgreen.mkt.usecase.CreateBrandUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.security.RolesAllowed;

@Slf4j
@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/brand")
public class BrandController implements BrandControllerApi {

    private final CreateBrandUseCase createBrandUseCase;

    @Override
    @PostMapping
    @RolesAllowed("admin")
    public ResponseEntity<Void> createBrand(BrandRequest brandRequest) {
        var brandDomain = new BrandRequestMapperImpl().brandRequestToDomain(brandRequest);

        var productBrandDomain = createBrandUseCase.execute(brandDomain);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productBrandDomain.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
