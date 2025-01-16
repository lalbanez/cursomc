package com.leandroalbanez.cursomc.config;

import com.leandroalbanez.cursomc.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean InstaciteDataBase() throws ParseException {

        if(!"create".equals(strategy)) {
            return false;
        }
        dbService.instanciateTestDataBase();
        return true;
    }
}
