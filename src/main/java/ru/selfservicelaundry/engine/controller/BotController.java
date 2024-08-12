package ru.selfservicelaundry.engine.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.selfservicelaundry.engine.api.BotApiImpl;
import ru.selfservicelaundry.engine.dto.SendMessageRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class BotController {
    private final BotApiImpl botApi;

    @PostMapping("/api/v1/heartbeatTest")
    public void heartbeatTest(@RequestBody String text) {
        botApi.sendMessage(
                SendMessageRequest.builder()
                        .chatId(849058073L)
                        .textToSend(text)
                        .inlineKeyboardMarkup(null)
                        .build()
        );
    }
}
