package ru.selfservicelaundry.engine.dto;

import lombok.Builder;
import lombok.Data;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.selfservicelaundry.engine.model.Laundry;

@Data
@Builder
public class TaskRunnerRequest {
    private Long chatId;
    private String laundryId;
    private InlineKeyboardMarkup inlineKeyboardMarkup;
}
