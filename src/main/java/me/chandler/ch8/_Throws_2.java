package me.chandler.ch8;

public class _Throws_1 {

    public static void main(String[] args) throws Exception {
        method1();
    }

    private static void method1() throws Exception {
        method2();
    }

    private static void method2() throws Exception {
        throw new Exception("예외>>>>");
    }
}
