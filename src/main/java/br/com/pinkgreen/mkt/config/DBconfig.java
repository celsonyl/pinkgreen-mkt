package br.com.pinkgreen.mkt.config;

import br.com.pinkgreen.mkt.gateway.postgresql.service.DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DBconfig {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private final String strategy;
    private final DBService dbService;

    @Bean
    public boolean instantiateDatabase() {
        if (!"create".equals(strategy))
            return false;

        dbService.instantiateTestDB();
        return true;
    }
}
