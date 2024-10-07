package me.chandler.java8._interface_change.default_method;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class SimpleTimeClient implements TimeClient {

    private LocalDateTime dateTime;

    public SimpleTimeClient() {
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public void setTime(int hour, int minute, int second) {
        LocalDate currentDate = LocalDate.from(this.dateTime);
        LocalTime timeToSet = LocalTime.of(hour, minute, second);
        this.dateTime = LocalDateTime.of(currentDate, timeToSet);
    }

    @Override
    public void setDate(int day, int month, int year) {
        LocalDate dateToSet = LocalDate.of(year, month, day);
        LocalTime timeToSet = LocalTime.from(this.dateTime);
        this.dateTime = LocalDateTime.of(dateToSet, timeToSet);
    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return this.dateTime;
    }

    public String toString() {
        return this.dateTime.toString();
    }

    @Override
    public ZonedDateTime getZonedDateTime(String zoneString) {
        // 재정의할 수 있다.
        return null;
    }

    public static void main(String[] args) {
        SimpleTimeClient myTimeClient = new SimpleTimeClient();
        System.out.println(myTimeClient.toString());

        myTimeClient.setTime(5, 52, 50);
        System.out.println(myTimeClient.getZonedDateTime("hahah").toString());
    }
}
