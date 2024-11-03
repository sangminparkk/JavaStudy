package me.chandler.ch8;

public class _Throws_2 {

    public static void main(String[] args) throws Exception {
        method1();
    }

    private static void method1() throws Exception {
        try {
            throw new Exception("예외>>>>"); // 예외를 발생만 시킴. 곧바로 해당 메세지가 출력되지 않습니다.
        } catch (Exception e) {
            System.out.println("method1메서드에서 예외가 처리되었습니다."); //1. 가장 먼저 출력
            e.printStackTrace(); // 2. e.getMessage와 함께 정보를 출력합니다.
        }
    }

    private static void method2() throws Exception {
        throw new Exception("예외>>>>");
    }
}
