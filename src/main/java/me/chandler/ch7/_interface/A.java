package me.chandler.ch7._interface;

public class A extends C implements I, Ia{

    @Override
    public void methodA(I i) {
        i.methodB();
    }

    @Override
    public void methodB() {
    }

    @Override
    public void methodC() {
        System.out.println("C를 오버라이딩 가능?");
    }

    @Override
    public void methodD() {
        I.super.methodD();
    }
}
