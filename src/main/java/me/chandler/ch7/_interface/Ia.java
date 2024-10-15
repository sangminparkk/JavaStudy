package me.chandler.ch7._interface;

public interface Ia {

    void methodA(I i);

    void methodB();

    default void methodD() {
        System.out.println("인터페이스 Ia의 디폴트 메서드 D 입니다.");
    }

}
