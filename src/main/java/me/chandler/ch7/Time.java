package me.chandler.ch7;

public class Time {

    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        // 제한
        if (hour < 0 || hour > 23) return;
        this.hour = hour;
    }

    @Override
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }
}
