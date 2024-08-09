package ru.selfservicelaundry.engine.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@ConfigurationProperties(prefix = "parser")
public class ParserConfig extends ClientConfig {

    @Bean
    public RestTemplate parserClient() {
        return new RestTemplate();
    }
}
