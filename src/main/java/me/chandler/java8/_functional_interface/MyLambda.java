package me.chandler.java8._functional_interface;

import java.util.function.Consumer;

public class MyLambda {
    public static void main(String[] args) {

        MyLambda myLambda = new MyLambda();
        myLambda.executeTask(); // 5
        myLambda.printNumber();

    }

    private void executeTask() {
        int count = 10;

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 5;
                System.out.println(count);
            }
        });
        thread.start();
    }

    private void printNumber() {
        int count = 10;

        Consumer<Integer> print = i -> {
//            int count = 10;
            System.out.println(i + count);
        };
    }
}
