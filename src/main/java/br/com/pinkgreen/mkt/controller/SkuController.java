package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.model.SkuRequest;
import br.com.pinkgreen.mkt.controller.model.SkuResponse;
import br.com.pinkgreen.mkt.controller.model.SkuUpdateRequest;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.translator.SkuProductMapperImpl;
import br.com.pinkgreen.mkt.usecase.CreateSkuProductUseCase;
import br.com.pinkgreen.mkt.usecase.GetSkuBySkuCodeUseCase;
import br.com.pinkgreen.mkt.usecase.UpdateSkuUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.security.RolesAllowed;

@Component
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/sku")
public class SkuController implements SkuControllerApi {

    private final CreateSkuProductUseCase createSkuProductUseCase;
    private final GetSkuBySkuCodeUseCase getSkuBySkuCodeUseCase;
    private final UpdateSkuUseCase updateSkuUseCase;

    @Override
    @PostMapping
    @RolesAllowed("admin")
    public ResponseEntity<Void> createSku(SkuRequest skuRequest) throws DataIntegrityException {
        var skuDomain = new SkuProductMapperImpl().skuRequestToDomain(skuRequest);
        var createSku = createSkuProductUseCase.execute(skuDomain);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createSku.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    @GetMapping(value = "/{code}")
    @RolesAllowed("user")
    public ResponseEntity<SkuResponse> findSku(String code) {
        var skuMapper = new SkuProductMapperImpl();
        var skuDomain = getSkuBySkuCodeUseCase.getSkuBySkuCode(code);

        return ResponseEntity.ok().body(skuMapper.skuDomainToResponse(skuDomain));
    }

    @Override
    @PutMapping(value = "/{code}")
    @RolesAllowed("admin")
    public ResponseEntity<Void> updateSku(String code, SkuUpdateRequest skuUpdateRequest) {
        var skuMapper = new SkuProductMapperImpl();

        var skuDomain = skuMapper.skuUpdateRequestToDomain(skuUpdateRequest);
        updateSkuUseCase.updateSku(code, skuDomain);
        return ResponseEntity.noContent().build();
    }
}
