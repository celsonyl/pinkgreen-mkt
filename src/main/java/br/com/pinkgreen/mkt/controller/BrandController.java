package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.model.BrandRequest;
import br.com.pinkgreen.mkt.controller.model.BrandResponse;
import br.com.pinkgreen.mkt.controller.translator.BrandRequestMapperImpl;
import br.com.pinkgreen.mkt.controller.translator.BrandResponseMapperImpl;
import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.usecase.CreateBrandUseCase;
import br.com.pinkgreen.mkt.usecase.GetAllBrandsUseCase;
import br.com.pinkgreen.mkt.usecase.GetBrandByIdUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/brand")
public class BrandController implements BrandControllerApi {

    private final CreateBrandUseCase createBrandUseCase;
    private final GetAllBrandsUseCase getAllBrandsUseCase;
    private final GetBrandByIdUseCase getBrandByIdUseCase;

    @Override
    @PostMapping
    @RolesAllowed("admin")
    public ResponseEntity<Void> createBrand(BrandRequest brandRequest) {
        var brandDomain = new BrandRequestMapperImpl().brandRequestToDomain(brandRequest);

        var productBrandDomain = createBrandUseCase.execute(brandDomain);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productBrandDomain.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @Override
    @GetMapping
    public ResponseEntity<List<BrandResponse>> getAllBrands() {
        List<BrandDomain> brandDomains = getAllBrandsUseCase.execute();

        return ResponseEntity.ok(brandDomains.stream()
                .map(new BrandResponseMapperImpl()::brandDomainToResponse)
                .collect(Collectors.toList()));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> findById(Integer id) {
        var brandDomain = getBrandByIdUseCase.execute(id);
        return ResponseEntity.ok(new BrandResponseMapperImpl().brandDomainToResponse(brandDomain));
    }
}
