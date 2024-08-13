package ru.selfservicelaundry.engine.service;

import org.jvnet.hk2.annotations.Service;
import ru.selfservicelaundry.engine.dto.TaskRunnerRequest;
import ru.selfservicelaundry.engine.model.AvailableSlots;

public interface BotService {
    AvailableSlots sendAvailable(TaskRunnerRequest taskRunnerRequest);
}
