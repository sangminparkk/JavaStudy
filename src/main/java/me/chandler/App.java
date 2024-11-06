package me.chandler;

public class App {
    public static void main( String[] args ) {

        Person personA = new Person("chandler");
        Person personB = new Person("chandler");

        System.out.println(personA);
        System.out.println(personB);
        System.out.println(personA.equals(personB));

        System.out.println(personA.hashCode());

        // 값만 비교하는거라면?
        System.out.println(personA.getName().equals(personB.getName()) );

        try {
            Person clone = personA.clone();
            System.out.println(clone.equals(personA));
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }
}