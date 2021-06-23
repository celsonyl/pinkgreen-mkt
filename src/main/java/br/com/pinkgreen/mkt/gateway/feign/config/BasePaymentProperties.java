package br.com.pinkgreen.mkt.gateway.feign.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.URI;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "payment")
public class BasePaymentProperties {
    private URI url;
}
