package ru.selfservicelaundry.engine.api;

import java.net.URI;
import java.util.Collections;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.selfservicelaundry.engine.config.ClientConfig;
import ru.selfservicelaundry.engine.config.ParserConfig;
import ru.selfservicelaundry.engine.model.AvailableSlots;
import ru.selfservicelaundry.engine.model.Laundries;
import ru.selfservicelaundry.engine.model.Laundry;

@Component
public class ParserApiImpl extends BaseApi implements ParserApi {

    private static final String LAUNDRIES_PATH = "api/v1/laundries";
    private static final String LAUNDRY_PATH = "api/v1/laundry";

    public ParserApiImpl(RestTemplate parserClient, ParserConfig parserConfig) {
        super(parserClient, parserConfig);
    }


    @Override
    public Laundries getLaundries() {
        return getRequest(LAUNDRIES_PATH, null, Laundries.class);
    }

    @Override
    public Laundry getLaundry(String laundryId) {
        return getRequest(String.format("%s/%s", LAUNDRY_PATH, laundryId), null, Laundry.class);
    }

    @Override
    public Boolean checkSlot(String laundryId, String slotId) {
        var params = new LinkedMultiValueMap<String, String>();
        params.put("slotId", Collections.singletonList(slotId));
        return getRequest(String.format("%s/%s/check", LAUNDRY_PATH, laundryId), params, Boolean.class);
    }

    @Override
    public AvailableSlots getAvailable(String laundryId) {
        return getRequest(String.format("%s/%s/available", LAUNDRY_PATH, laundryId), null, AvailableSlots.class);
    }



}