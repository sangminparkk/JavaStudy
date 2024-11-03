package me.chandler.ch8;

public class _TryAndCatch_2 {
    public static void main(String[] args) {
        try {
            throw new Exception("고의로 예외 발생");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println(">> 프로그램이 정상 종료되었습니다.");
    }
}
