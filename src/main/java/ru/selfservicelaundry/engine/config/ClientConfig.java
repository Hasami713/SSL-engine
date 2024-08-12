package ru.selfservicelaundry.engine.config;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ClientConfig {
    private String url;

}
