package br.com.pinkgreen.mkt.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Component
@RestController
@RequestMapping("/catalog")
public class CatalogControllerApiImpl implements CatalogControllerApi {

    @Override
    @PostMapping()
    public ResponseEntity createCategory() {
        return null;
    }
}
