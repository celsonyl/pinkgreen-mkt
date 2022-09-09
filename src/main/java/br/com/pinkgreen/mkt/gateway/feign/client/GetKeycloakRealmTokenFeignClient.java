package br.com.pinkgreen.mkt.gateway.feign.client;

import br.com.pinkgreen.mkt.gateway.feign.config.KeycloakRealmFeignConfig;
import br.com.pinkgreen.mkt.gateway.feign.model.KeycloakTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@FeignClient(value = "GetKeycloakRealmToken", configuration = KeycloakRealmFeignConfig.class)
public interface GetKeycloakRealmTokenFeignClient {
    @PostMapping(value = "/token", consumes = APPLICATION_FORM_URLENCODED_VALUE)
    KeycloakTokenResponse execute(URI baseUrl, @RequestBody Map<String, ?> request);
}
