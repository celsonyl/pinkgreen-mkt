package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.SkuAdministrationControllerApi;
import br.com.pinkgreen.mkt.controller.model.SkuRequest;
import br.com.pinkgreen.mkt.controller.model.SkuUpdateRequest;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.gateway.DeleteSkuByCodeGateway;
import br.com.pinkgreen.mkt.translator.SkuProductMapperImpl;
import br.com.pinkgreen.mkt.usecase.CreateSkuProductUseCase;
import br.com.pinkgreen.mkt.usecase.UpdateSkuUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.ResponseEntity.noContent;

@Component
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/sku-administration")
public class SkuAdministrationController implements SkuAdministrationControllerApi {

    private final CreateSkuProductUseCase createSkuProductUseCase;
    private final UpdateSkuUseCase updateSkuUseCase;
    private final DeleteSkuByCodeGateway deleteSkuByCode;

    @Override
    @PostMapping("/sku")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> createSku(SkuRequest skuRequest, UriComponentsBuilder uriComponentsBuilder) throws DataIntegrityException {
        var skuDomain = new SkuProductMapperImpl().skuRequestToDomain(skuRequest);
        var createSku = createSkuProductUseCase.execute(skuDomain);
        var uri = uriComponentsBuilder.path("sku/{id}").buildAndExpand(createSku.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    @PutMapping(value = "/sku/{code}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> updateSku(String code, SkuUpdateRequest skuUpdateRequest) {
        var skuMapper = new SkuProductMapperImpl();

        var skuDomain = skuMapper.skuUpdateRequestToDomain(skuUpdateRequest);
        updateSkuUseCase.updateSku(code, skuDomain);
        return noContent().build();
    }

    @Override
    @DeleteMapping(value = "/sku/{code}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> deleteByCode(String code) {
        deleteSkuByCode.execute(code);
        return noContent().build();
    }
}
