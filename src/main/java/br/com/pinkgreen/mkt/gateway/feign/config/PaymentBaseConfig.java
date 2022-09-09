package br.com.pinkgreen.mkt.gateway.feign.config;

import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;

public class PaymentBaseConfig {

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }
}
