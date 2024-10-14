package me.chandler.ch7._abstract;

public class AudioPlayer extends Player{

    public AudioPlayer() {
        super();
    }

    @Override
    void play(int pos) {
        // 구현부 작성
    }

    @Override
    void stop() {
        // 구현부 작성
    }

    @Override
    void play() {
        super.play();
    }
}
