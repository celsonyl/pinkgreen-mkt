package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.BrandAdministrationControllerApi;
import br.com.pinkgreen.mkt.controller.model.BrandRequest;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.exception.BrandIsNotAbleToBeDeletedException;
import br.com.pinkgreen.mkt.gateway.UpdateBrandByIdGateway;
import br.com.pinkgreen.mkt.translator.BrandMapperImpl;
import br.com.pinkgreen.mkt.usecase.*;
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
@RequestMapping("/brand-administration")
public class BrandAdministrationController implements BrandAdministrationControllerApi {

    private final CreateBrandUseCase createBrandUseCase;
    private final DeleteBrandByIdUseCase deleteBrandById;
    private final UpdateBrandByIdGateway updateBrandById;

    @Override
    @PostMapping("/brand")
    @CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "Location")
    public ResponseEntity<Void> createBrand(BrandRequest brandRequest, UriComponentsBuilder uriComponentsBuilder) throws DataIntegrityException {
        var brandDomain = new BrandMapperImpl().brandRequestToDomain(brandRequest);

        var productBrandDomain = createBrandUseCase.execute(brandDomain);
        var uri = uriComponentsBuilder.path("brand/{id}").buildAndExpand(productBrandDomain.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @Override
    @DeleteMapping("/brand/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> deleteById(Integer id) throws BrandIsNotAbleToBeDeletedException {
        deleteBrandById.execute(id);
        return noContent().build();
    }

    @Override
    @PutMapping("/brand/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> updateById(Integer id, BrandRequest brandRequest) {
        updateBrandById.execute(id, new BrandMapperImpl().brandRequestToDomain(brandRequest));
        return noContent().build();
    }
}
