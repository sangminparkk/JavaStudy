package me.chandler.ch8;

public class _Rethrows_1 {

    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("main 에외처리");
        }
    }

    private static void method1() throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("method1 예외처리");
            throw e;
        }
    }
}
