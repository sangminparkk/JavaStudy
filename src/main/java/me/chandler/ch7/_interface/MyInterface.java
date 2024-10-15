package me.chandler.ch7._interface;

public interface MyInterface {

    void method();

    void newMethod();

    default void new2Method() {
        System.out.println("구현부");
    }
}
