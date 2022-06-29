package br.com.pinkgreen.mkt.config;

import br.com.pinkgreen.mkt.gateway.postgresql.service.DBService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBconfig {

    private final DBService dbService;

    public DBconfig(DBService dbService) {
        this.dbService = dbService;
    }

    @Bean
    public boolean instantiateDatabase() {
        dbService.instantiateTestDB();
        return true;
    }
}
