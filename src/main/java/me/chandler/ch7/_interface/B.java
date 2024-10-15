package me.chandler.ch7._interface;

public class B implements I{

    @Override
    public void methodA(I i) {
    }

    @Override
    public void methodB() {
        System.out.println("B.methodB");
    }
}
