package me.chandler.ch8;

public class MyException extends Exception{

    private final int CODE;

    public MyException(String message, int code) {
        super(message);
        this.CODE = code;
    }

    public MyException(String message) {
        this(message, 100);
    }

    public int getCODE() {
        return CODE;
    }
}
