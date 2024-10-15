package me.chandler.ch7._interface;

public interface I {

    void methodA(I i);

    void methodB();

    default void methodC() {
        System.out.println("디폴트 메서드 C 입니다.");
    }

    default void methodD() {
        System.out.println("인터페이스 I의 디폴트 메서드 D 입니다.");
    }
}
