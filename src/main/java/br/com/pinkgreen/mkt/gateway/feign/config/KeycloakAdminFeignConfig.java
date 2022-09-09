package br.com.pinkgreen.mkt.gateway.feign.config;

import br.com.pinkgreen.mkt.gateway.feign.authenticator.KeycloakRealmAuthenticator;
import feign.RequestInterceptor;
import feign.okhttp.OkHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RequiredArgsConstructor
public class KeycloakAdminFeignConfig {

    private final KeycloakRealmAuthenticator authenticator;

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return it -> it.header(AUTHORIZATION, authenticator.getToken());
    }
}
