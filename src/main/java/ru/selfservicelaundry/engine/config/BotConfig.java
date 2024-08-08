package ru.selfservicelaundry.engine.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@ConfigurationProperties(prefix = "bot")
public record BotConfig(String url) {
    @Bean
    public RestTemplate botClient() {
        return new RestTemplate();
    }
}
