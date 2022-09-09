package br.com.pinkgreen.mkt.gateway.feign.client;

import br.com.pinkgreen.mkt.gateway.feign.config.KeycloakAdminFeignConfig;
import br.com.pinkgreen.mkt.gateway.feign.model.UserKeycloakResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URI;

@FeignClient(value = "FindUserById", configuration = KeycloakAdminFeignConfig.class)
public interface FindUserByIdOnKeycloakFeignApi {

    @GetMapping("/users/{customerId}")
    UserKeycloakResponse execute(URI baseUrl, @PathVariable("customerId") String customerId);
}
