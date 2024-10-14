package me.chandler.ch7;

public class Fightable implements Movable, Attacktable {

    @Override
    public Movable move(int x, int y) {
        System.out.println("하하");
        return (x1, y1) -> null;
    }

    @Override
    public void attack() {

    }
}
