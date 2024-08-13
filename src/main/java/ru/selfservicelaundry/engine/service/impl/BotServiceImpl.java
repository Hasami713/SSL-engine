package ru.selfservicelaundry.engine.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.selfservicelaundry.engine.api.ParserApi;
import ru.selfservicelaundry.engine.api.ParserApiImpl;
import ru.selfservicelaundry.engine.dto.TaskRunnerRequest;
import ru.selfservicelaundry.engine.model.AvailableSlots;
import ru.selfservicelaundry.engine.service.BotService;

@Service
@RequiredArgsConstructor
public class BotServiceImpl implements BotService {
    private final ParserApi parserApi;

    public AvailableSlots sendAvailable(TaskRunnerRequest taskRunnerRequest) {
        return (AvailableSlots) parserApi.getAvailable(taskRunnerRequest.getLaundryId());
    }
}
