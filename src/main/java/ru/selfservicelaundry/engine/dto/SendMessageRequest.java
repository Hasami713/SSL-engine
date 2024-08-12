package ru.selfservicelaundry.engine.dto;

import lombok.Builder;
import lombok.Data;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Data
@Builder
public class SendMessageRequest {
    private Long chatId;
    private String textToSend;
    private InlineKeyboardMarkup inlineKeyboardMarkup;
}
