package me.chandler;

import me.chandler.java8._stream.OnlineClass;

import java.util.*;

public class App {
    public static void main( String[] args ) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));


        OnlineClass springBoot = new OnlineClass(1, "spring boot", true);
    }

}