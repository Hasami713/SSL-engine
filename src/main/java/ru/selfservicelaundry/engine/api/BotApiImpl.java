package ru.selfservicelaundry.engine.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.selfservicelaundry.engine.config.BotConfig;
import ru.selfservicelaundry.engine.config.ClientConfig;
import ru.selfservicelaundry.engine.dto.SendMessageRequest;
import ru.selfservicelaundry.engine.model.Laundry;


@Slf4j
@Component
public class BotApiImpl extends BaseApi implements BotApi {
    private static final String SEND_MESSAGE = "api/v1/availableSlots";


    public BotApiImpl(RestTemplate botClient, BotConfig botConfig) {
        super(botClient, botConfig);
    }

    @Override
    public void sendMessage(SendMessageRequest sendMessageRequest) {
        postRequest(SEND_MESSAGE, null, sendMessageRequest, SendMessageRequest.class);
    }
}
