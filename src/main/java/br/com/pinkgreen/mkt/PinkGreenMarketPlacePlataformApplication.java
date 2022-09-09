package br.com.pinkgreen.mkt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PinkGreenMarketPlacePlataformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinkGreenMarketPlacePlataformApplication.class, args);
    }

}
