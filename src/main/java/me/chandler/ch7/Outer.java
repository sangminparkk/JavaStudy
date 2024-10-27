package me.chandler.ch7;

public class Outer {

    int value = 10;

    class Inner {

        int value = 20;
        void method1() {
            int value = 30;
            System.out.println("value = " + value); // 30
            System.out.println("this.value = " + this.value); // 20
            System.out.println("Outer.this.value = " + Outer.this.value); // 10
        }
    }
}

class Ex5 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method1();
    }
}

