package ru.selfservicelaundry.engine.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.selfservicelaundry.engine.api.BotApiImpl;
import ru.selfservicelaundry.engine.dto.SendMessageRequest;
import ru.selfservicelaundry.engine.dto.TaskRunnerRequest;
import ru.selfservicelaundry.engine.service.BotService;
import ru.selfservicelaundry.engine.task.ScheduledTask;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class BotController {
    private final BotApiImpl botApi;
    private final ScheduledTask scheduledTask;

    @PostMapping("/api/v1/taskRunner")
    public void taskRunner(@RequestBody TaskRunnerRequest taskRunnerRequest) {
        botApi.sendMessage(
                SendMessageRequest.builder()
                        .chatId(taskRunnerRequest.getChatId())
                        .textToSend(scheduledTask.runTask(taskRunnerRequest).toString())
                        .inlineKeyboardMarkup(taskRunnerRequest.getInlineKeyboardMarkup())
                        .build()
        );
    }
}
