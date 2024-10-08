package me.chandler.java8._interface_change.default_method;

import java.util.List;


public class Article {

    private List<Author> listOfAuthors;
    private int id;
    private String name;

    public Article(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
