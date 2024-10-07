package me.chandler.java8._interface_change.default_method;

import java.time.ZonedDateTime;

public interface AbstractZoneTimeClient extends TimeClient{

    ZonedDateTime getZonedDateTime(String zoneString);
}
