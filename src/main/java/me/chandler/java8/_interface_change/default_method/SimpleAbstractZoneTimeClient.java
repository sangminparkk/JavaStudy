package me.chandler.java8._interface_change.default_method;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class SimpleAbstractZoneTimeClient implements AbstractZoneTimeClient{

    @Override
    public ZonedDateTime getZonedDateTime(String zoneString) {
        return null;
    }

    @Override
    public void setTime(int hour, int minute, int second) {

    }

    @Override
    public void setDate(int day, int month, int year) {

    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return null;
    }
}
