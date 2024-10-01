package me.chandler.java8._functional_interface;

import java.util.function.*;

/**
 * 1) 함수형 인터페이스 생성
 * 2) 함수 호출
 * 3) 함수 조합용 메서드
 */
public class MyFunctionalInterface {
    public static void main(String[] args) {

        System.out.println("==Function<T,R>==");
        Function<Integer, Integer> plus5 = integer -> integer + 5;
        Function<Integer, Integer> multiply2 = i -> i * 2;

        System.out.println("==apply: 함수호출==");
        System.out.println(plus5.apply(5));
        System.out.println(multiply2.apply(4));

        System.out.println("==compose: multiply2 -> plus5==");
        Function<Integer, Integer> compose = plus5.compose(multiply2);
        System.out.println(compose.apply(3)); // (3 * 2) + 5 = 11

        System.out.println("==andThen: plus5 -> multiply2==");
        Function<Integer, Integer> andThen = plus5.andThen(multiply2);
        System.out.println(andThen.apply(4)); // (5 + 4) * 2 = 18

        System.out.println("==BiFunction<T,U,R>==");
        BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;
        System.out.println(sum.apply(2, 5));

        System.out.println("==BiFunction andThen==");
        BiFunction<Integer, Integer, Integer> sumAndThenMultiply2 = sum.andThen(multiply2);
        System.out.println(sumAndThenMultiply2.apply(3, 4)); // (3+4) * 2 = 14

        System.out.println("==Consumer<T>==");
        Consumer<Integer> printNumber = (number) -> System.out.println(number);
        printNumber.accept(20);

        System.out.println("==Supplier<T>==");
        Supplier<String> printNikeLogo = () -> "Just do it!";
        System.out.println(printNikeLogo.get());

        System.out.println("==Predicate<T>==");
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println(isEven.test(4));
        Predicate<String> startsWithChandler = (s) -> s.startsWith("chandler");
        System.out.println(startsWithChandler.test("haha"));

        System.out.println("==UnaryOperator<T>==");
//        Function<Integer, Integer> plus10 = (number) -> number + 10;
        UnaryOperator<Integer> plus10 = (number) -> number + 10;
        System.out.println(plus10.apply(2));

        System.out.println("==BinaryOperator<T>==");
//        BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;
        BinaryOperator<Integer> addNumbers = (x, y) -> x + y;
        System.out.println(addNumbers.apply(5,10));
    }

}
