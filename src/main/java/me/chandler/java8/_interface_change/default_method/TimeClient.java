package me.chandler.java8._interface_change.default_method;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface TimeClient {

    void setTime(int hour, int minute, int second);

    void setDate(int day, int month, int year);

    LocalDateTime getLocalDateTime();

    default ZonedDateTime getZonedDateTime(String zoneString) {
        return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
    }

    static ZoneId getZoneId(String zoneString) {
        try {
            return ZoneId.of(zoneString);
        } catch (DateTimeException e) {
            System.out.println(e.getMessage());
            return ZoneId.systemDefault();
        }
    }

}
