package me.chandler.ch7._abstract;

abstract class AbstractPlayer extends Player{

    @Override
    void play(int pos) {

    }

    @Override
    void stop() {

    }

    public AbstractPlayer() {
        super();
    }

    @Override
    void play() {
        super.play();
    }
}
