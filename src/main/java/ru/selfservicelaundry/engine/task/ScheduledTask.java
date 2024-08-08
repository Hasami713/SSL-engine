package ru.selfservicelaundry.engine.task;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.selfservicelaundry.engine.service.MetricsService;

@Component
@RequiredArgsConstructor
public class ScheduledTask {

    private final MetricsService metricsService;

    @Scheduled(fixedRateString = "${task.rate}")
    public void runTask() {
        metricsService.collect();
    }
}
