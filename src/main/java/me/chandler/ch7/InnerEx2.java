package me.chandler.ch7;

public class InnerEx2 {

    class InstanceInner {

    }

    static class StaticInner {

    }

    InstanceInner instanceInner = new InstanceInner();
    StaticInner staticInner = new StaticInner();

    static void staticMethod() {
//        InstanceInner instanceInner = new InstanceInner();
        StaticInner staticInner = new StaticInner();


        // 만약에 instance 필드에 접근 하고 싶으면?
        InnerEx2 outer = new InnerEx2();
        InstanceInner innerInstance = outer.new InstanceInner();
    }

    void instanceMethod() {
        InstanceInner instanceInner1 = new InstanceInner();
        StaticInner staticInner1 = new StaticInner();
//        LocalInner localInner = new LocalInner();
    }

    void myMethod() {
        class LocalInner {}
        LocalInner localInner = new LocalInner();
    }
}
