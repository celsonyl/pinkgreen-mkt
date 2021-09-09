package br.com.pinkgreen.mkt;

import br.com.pinkgreen.mkt.gateway.feign.config.BasePaymentProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties({BasePaymentProperties.class})
public class PinkGreenMarketPlacePlataformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinkGreenMarketPlacePlataformApplication.class, args);
    }

}
