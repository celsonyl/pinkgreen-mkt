package br.com.pinkgreen.mkt.gateway.feign.authenticator;

import br.com.pinkgreen.mkt.gateway.feign.client.GetKeycloakRealmTokenFeignClient;
import br.com.pinkgreen.mkt.gateway.feign.model.KeycloakTokenRequest;
import br.com.pinkgreen.mkt.gateway.feign.properties.KeycloakRealmProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Component
@RequiredArgsConstructor
public class KeycloakRealmAuthenticator {
    private static LocalDateTime tokenExpiration = now();
    private static String token = "";

    private final GetKeycloakRealmTokenFeignClient client;
    private final KeycloakRealmProperties properties;

    public String getToken() {
        updateAndGetToken();
        return token;
    }

    private synchronized void updateAndGetToken() {
        if (now().isAfter(tokenExpiration) || token.isEmpty()) {
            var request = new KeycloakTokenRequest(
                    properties.getGrantType(),
                    properties.getClientId(),
                    properties.getClientSecret()
            );

            var response = client.execute(properties.getUrl(), request.toMap());

            tokenExpiration = now().plusSeconds(response.getExpiresIn());
            token = response.getTokenType() + " " + response.getAccessToken();
        }
    }
}
