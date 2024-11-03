package me.chandler.ch8;

public class _TryAndCatch_1 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println(3);
//            System.out.println(4/0);
            System.out.println(4);
        } catch (ArithmeticException e) {
            System.out.println(5);
        }
        System.out.println(6);
        // close
        /**
         * 1
         * 2
         * 3 (~try block)
         * 5 (catch block)
         * 6 (escape from a loop of try-catch)
         */
    }
}
