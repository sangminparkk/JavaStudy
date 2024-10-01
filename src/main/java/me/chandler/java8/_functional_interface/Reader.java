package me.chandler.java8._functional_interface;

public class Reader {
    public static void main(String[] args) {
        Book book = (name) -> System.out.println("책 이름 : " + name);
        book.description("자바8");
    }
}
