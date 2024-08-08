package ru.selfservicelaundry.engine.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "task")
public record TaskConfig(long rate) {}
