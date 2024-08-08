package ru.selfservicelaundry.engine.api;

import java.util.List;
import ru.selfservicelaundry.engine.model.Laundries;
import ru.selfservicelaundry.engine.model.Laundry;

public interface ParserApi {
     Laundries getLaundries();
     Laundry getLaundry(String laundryId);
     Boolean checkSlot(String laundryId, String slotId);
     List<String> getAvailable(String laundryId);
}