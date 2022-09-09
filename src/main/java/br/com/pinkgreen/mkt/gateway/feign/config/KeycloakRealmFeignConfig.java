package br.com.pinkgreen.mkt.gateway.feign.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;

public class KeycloakRealmFeignConfig {

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    Encoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {
        return new SpringFormEncoder(new SpringEncoder(converters));
    }

}
