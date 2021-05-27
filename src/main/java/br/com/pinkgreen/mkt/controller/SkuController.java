package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.model.SkuRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SkuController implements SkuControllerApi {

    @Override
    public ResponseEntity<Void> createSku(SkuRequest skuRequest) {
        return null;
    }
}
