package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.SkuAdministrationControllerApi;
import br.com.pinkgreen.mkt.controller.model.SkuRequest;
import br.com.pinkgreen.mkt.controller.model.SkuResponse;
import br.com.pinkgreen.mkt.controller.model.SkuUpdateRequest;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.domain.exception.ObjectNotFoundException;
import br.com.pinkgreen.mkt.gateway.DeleteSkuByCodeGateway;
import br.com.pinkgreen.mkt.gateway.FindSkuByCodeGateway;
import br.com.pinkgreen.mkt.gateway.FindSkusByProductIdGateway;
import br.com.pinkgreen.mkt.translator.SkuProductMapperImpl;
import br.com.pinkgreen.mkt.usecase.CreateSkuProductUseCase;
import br.com.pinkgreen.mkt.usecase.GetAllSkusUseCase;
import br.com.pinkgreen.mkt.usecase.UpdateSkuUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@Component
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/sku-administration")
public class SkuAdministrationController implements SkuAdministrationControllerApi {

    private final CreateSkuProductUseCase createSkuProductUseCase;
    private final UpdateSkuUseCase updateSkuUseCase;
    private final DeleteSkuByCodeGateway deleteSkuByCode;
    private final GetAllSkusUseCase getAllSkusUseCase;
    private final FindSkuByCodeGateway findSkuByCode;
    private final FindSkusByProductIdGateway findSkusByProductId;

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

    @Override
    @GetMapping("/sku")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<SkuResponse>> findAllSkus() {
        var skuMapper = new SkuProductMapperImpl();
        var skusDomain = getAllSkusUseCase.execute();

        return ResponseEntity.ok().body(skusDomain.stream()
                .map(skuMapper::skuDomainToResponse)
                .collect(toList()));
    }

    @Override
    @GetMapping(value = "/sku/{code}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<SkuResponse> findByCode(String code) {
        SkuResponse sku = findSkuByCode.execute(code)
                .map(it -> new SkuProductMapperImpl().skuDomainToResponse(it))
                .orElseThrow(() -> new ObjectNotFoundException("SKU não encontrado: " + code));
        return ok(sku);
    }

    @Override
    @GetMapping(value = "/sku/product/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<SkuResponse>> findSkusByProductId(Integer id) {
        List<SkuResponse> skus = findSkusByProductId.execute(id).stream()
                .map(it -> new SkuProductMapperImpl().skuDomainToResponse(it))
                .collect(toList());
        return ok(skus);
    }
}
