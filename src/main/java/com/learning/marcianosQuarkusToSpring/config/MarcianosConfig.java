package com.learning.marcianosQuarkusToSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MarcianosConfig {

    @Bean
    public RestTemplate myRestTemplate() {
        return new RestTemplate();
    }

}
