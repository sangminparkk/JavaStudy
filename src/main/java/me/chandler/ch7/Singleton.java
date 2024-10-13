package me.chandler.ch7;

final class Singleton { // 상속 제한 + 접근제어자 생략되어 default 접근 수준 적용

    private static Singleton s;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (s == null) {
            s = new Singleton();
        }
        return s;
    }
}
