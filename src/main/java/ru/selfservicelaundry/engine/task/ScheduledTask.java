package ru.selfservicelaundry.engine.task;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.selfservicelaundry.engine.service.BotService;
import ru.selfservicelaundry.engine.service.MetricsService;

import java.util.PrimitiveIterator;

@Component
@RequiredArgsConstructor
public class ScheduledTask {

    private final MetricsService metricsService;
    private final BotService botService;
    @Scheduled(fixedRateString = "${task.rate}")
    public void runTask() {
        metricsService.collect();
    }
}
