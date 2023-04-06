package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.SkuControllerApi;
import br.com.pinkgreen.mkt.controller.model.SkuByProductIdResponse;
import br.com.pinkgreen.mkt.controller.model.SkuResponse;
import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.translator.SkuProductMapperImpl;
import br.com.pinkgreen.mkt.usecase.GetAllEnabledSkusByProductIdUseCase;
import br.com.pinkgreen.mkt.usecase.GetAllSkusUseCase;
import br.com.pinkgreen.mkt.usecase.GetEnabledSkuBySkuCodeUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/sku")
public class SkuController implements SkuControllerApi {

    private final GetEnabledSkuBySkuCodeUseCase getEnabledSkuBySkuCodeUseCase;
    private final GetAllEnabledSkusByProductIdUseCase getAllEnabledSkusByProductIdUseCase;
    private final GetAllSkusUseCase getAllSkusUseCase;

    @Override
    @GetMapping(value = "/{code}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<SkuResponse> findSku(String code) {
        var skuMapper = new SkuProductMapperImpl();
        var skuDomain = getEnabledSkuBySkuCodeUseCase.getSkuBySkuCode(code);

        return ResponseEntity.ok().body(skuMapper.skuDomainToResponse(skuDomain));
    }

    @Override
    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<SkuResponse>> findAllSkus() {
        var skuMapper = new SkuProductMapperImpl();
        var skusDomain = getAllSkusUseCase.execute();

        return ResponseEntity.ok().body(skusDomain.stream()
                .map(skuMapper::skuDomainToResponse)
                .collect(Collectors.toList()));
    }

    @Override
    @GetMapping(value = "/product_skus/{productId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<SkuByProductIdResponse>> findAllSkuByProductId(Integer productId) {
        var skuMapper = new SkuProductMapperImpl();

        List<SkuDomain> skuDomains = getAllEnabledSkusByProductIdUseCase.execute(productId);

        return ResponseEntity.ok().body(skuDomains.stream()
                .map(skuMapper::skuDomainToSkuByProductIdResponse)
                .collect(Collectors.toList()));
    }
}
