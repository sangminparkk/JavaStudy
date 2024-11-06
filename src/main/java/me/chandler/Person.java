package me.chandler;

public class Person implements Cloneable { // Cloneable 마커 인터페이스, 미구현시 복제 허용 불가

    String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}
