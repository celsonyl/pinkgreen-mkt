package br.com.pinkgreen.mkt.config;

import br.com.pinkgreen.mkt.gateway.postgresql.service.DBService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBconfig {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;
    private final DBService dbService;

    public DBconfig(DBService dbService) {
        this.dbService = dbService;
    }

    @Bean
    public boolean instantiateDatabase() {
        if (!"create".equals(strategy))
            return false;

        dbService.instantiateTestDB();
        return true;
    }
}
