package me.chandler.ch7._abstract;

abstract class Player {

    int currentPos;

    public Player() {
        this.currentPos = 0;
    }

    abstract void play(int pos);

    abstract void stop();

    void play() {
        play(this.currentPos);
    }

}
