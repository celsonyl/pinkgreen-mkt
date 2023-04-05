package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.BrandControllerApi;
import br.com.pinkgreen.mkt.controller.model.BrandRequest;
import br.com.pinkgreen.mkt.controller.model.BrandResponse;
import br.com.pinkgreen.mkt.controller.util.URL;
import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.translator.BrandMapperImpl;
import br.com.pinkgreen.mkt.usecase.CreateBrandUseCase;
import br.com.pinkgreen.mkt.usecase.GetAllBrandsUseCase;
import br.com.pinkgreen.mkt.usecase.GetBrandByIdUseCase;
import br.com.pinkgreen.mkt.usecase.SearchBrandsByTextUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
@RequestMapping("/brand")
public class BrandController implements BrandControllerApi {

    private final CreateBrandUseCase createBrandUseCase;
    private final GetAllBrandsUseCase getAllBrandsUseCase;
    private final GetBrandByIdUseCase getBrandByIdUseCase;
    private final SearchBrandsByTextUseCase searchBrandsByTextUseCase;

    @Override
    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> createBrand(BrandRequest brandRequest, UriComponentsBuilder uriComponentsBuilder) throws DataIntegrityException {
        var brandDomain = new BrandMapperImpl().brandRequestToDomain(brandRequest);

        var productBrandDomain = createBrandUseCase.execute(brandDomain);
        var uri = uriComponentsBuilder.path("brand/{id}").buildAndExpand(productBrandDomain.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @Override
    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<BrandResponse>> getAllBrands() {
        List<BrandDomain> brandDomains = getAllBrandsUseCase.execute();

        return ResponseEntity.ok(brandDomains.stream()
                .map(new BrandMapperImpl()::brandDomainToResponse)
                .collect(Collectors.toList()));
    }

    @Override
    @GetMapping("/search")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<BrandResponse>> brandSearch(String text) {
        text = URL.decodeParam(text);
        List<BrandDomain> searchBrand = searchBrandsByTextUseCase.searchBrand(text);

        return ResponseEntity.ok(searchBrand.stream()
                .map(new BrandMapperImpl()::brandDomainToResponse)
                .collect(Collectors.toList()));
    }

    @Override
    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<BrandResponse> findById(Integer id) {
        var brandDomain = getBrandByIdUseCase.execute(id);
        return ResponseEntity.ok(new BrandMapperImpl().brandDomainToResponse(brandDomain));
    }
}
