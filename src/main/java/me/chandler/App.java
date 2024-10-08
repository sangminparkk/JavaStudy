package me.chandler;

import me.chandler.java8._interface_change.default_method.Article;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main( String[] args ) {
        List<Article> articles = Stream.generate(() -> new Article("Java"))
                .limit(35000)
                .collect(Collectors.toList());

        Spliterator<Article> spliterator = articles.spliterator();
        while (spliterator.tryAdvance(article -> article.setName(article.getName().concat("- published by xxx"))));

        articles.forEach(article -> System.out.println(article.getName()));
        //Java- published by xxx
    }
}