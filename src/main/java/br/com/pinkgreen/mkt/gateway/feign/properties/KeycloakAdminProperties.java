package br.com.pinkgreen.mkt.gateway.feign.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.URI;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "keycloak.admin")
public class KeycloakAdminProperties {
    private URI url;
}
