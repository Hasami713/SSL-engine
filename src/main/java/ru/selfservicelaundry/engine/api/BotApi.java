package ru.selfservicelaundry.engine.api;

import ru.selfservicelaundry.engine.dto.SendMessageRequest;

public interface BotApi {
    void sendMessage(SendMessageRequest sendMessageRequest);
}
