package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.CustomerIntentionsControllerApi;
import br.com.pinkgreen.mkt.controller.model.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
@RequestMapping("/customer-intentions")
public class CustomerIntentionsController implements CustomerIntentionsControllerApi {
    @Override
    @GetMapping("/{customerId}")
    public ResponseEntity<List<ProductResponse>> getProdutIntention() {
        return null;
    }
}
