package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.BrandControllerApi;
import br.com.pinkgreen.mkt.controller.model.BrandRequest;
import br.com.pinkgreen.mkt.controller.model.BrandResponse;
import br.com.pinkgreen.mkt.controller.util.URL;
import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.exception.BrandIsNotAbleToBeDeletedException;
import br.com.pinkgreen.mkt.gateway.DeleteBrandByIdGateway;
import br.com.pinkgreen.mkt.translator.BrandMapperImpl;
import br.com.pinkgreen.mkt.usecase.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.noContent;

@Slf4j
@Component
@RequiredArgsConstructor
@RequestMapping("/brand")
public class BrandController implements BrandControllerApi {

    private final GetAllBrandsUseCase getAllBrandsUseCase;
    private final GetBrandByIdUseCase getBrandByIdUseCase;
    private final SearchBrandsByTextUseCase searchBrandsByTextUseCase;

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
