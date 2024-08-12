package ru.selfservicelaundry.engine.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@ConfigurationProperties(prefix = "bot")
public class BotConfig extends ClientConfig {
    @Bean
    public RestTemplate botClient() {
        return new RestTemplate();
    }
}
