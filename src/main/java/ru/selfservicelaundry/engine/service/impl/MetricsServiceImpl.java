package ru.selfservicelaundry.engine.service.impl;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.selfservicelaundry.engine.api.ParserApi;
import ru.selfservicelaundry.engine.model.Laundry;
import ru.selfservicelaundry.engine.service.MetricsService;

@Service
@RequiredArgsConstructor
public class MetricsServiceImpl implements MetricsService {

    public static final String AVAILABILITY_METRIC = "availability";

    private final MeterRegistry meterRegistry;
    private final ParserApi parserApi;

    @PostConstruct
    public void init() {
    }

    @Override
    public void collect() {
        var laundries = parserApi.getLaundries();

        for (Laundry info : laundries) {
            var laundry = parserApi.getLaundry(info.getLaundryId());

            for (var slot : laundry.getSlots()) {
                updateAvailability(laundry.getLaundryId(), slot.slotId(), slot.available());
            }
        }
    }

    private void updateAvailability(String laundryId, String slotId, boolean available) {
        Gauge
                .builder(AVAILABILITY_METRIC, available, value -> available ? 1 : 0)
                .tags("laundryId", laundryId, "slotId", slotId)
                .register(meterRegistry);
    }
}
