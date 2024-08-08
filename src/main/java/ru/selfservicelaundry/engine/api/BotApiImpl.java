package ru.selfservicelaundry.engine.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.selfservicelaundry.engine.dto.SendMessageRequest;
import ru.selfservicelaundry.engine.model.Laundry;

@Component
@RequiredArgsConstructor
public class BotApiImpl implements BotApi {
    private static final String SEND_MESSAGE = "api/v1/availableSlots";

    private  final RestTemplate botClient;
    @Override
    public void sendMessage(SendMessageRequest sendMessageRequest) {
        botClient.postForObject(SEND_MESSAGE)
    }
}
