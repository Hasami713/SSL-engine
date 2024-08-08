package ru.selfservicelaundry.engine.dto;

import lombok.Data;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Data
public class SendMessageRequest {
    private Long chatId;
    private String textToSend;
    private InlineKeyboardMarkup inlineKeyboardMarkup;
}
