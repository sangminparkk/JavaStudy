package me.chandler.ch7;

public class Card {

    final int NUMBER;
    final String KIND;
    static int width = 100;
    static int height = 250;

    public Card(int number, String kind) {
        this.NUMBER = number;
        this.KIND = kind;
    }

    public Card() {
        this(1,"HEART");
    }

    public static void main(String[] args) {

        Card card = new Card(5,"HEART");
//        card.NUMBER = 20; //Cannot assign a value to final variable 'NUMBER'
    }
}
