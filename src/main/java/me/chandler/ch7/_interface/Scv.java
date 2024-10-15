package me.chandler.ch7._interface;

public class Scv extends GroundUnit implements Repairable{

    public Scv() {
        super(60);
        hitPoint = MAX_HP;
    }

    @Override
    public void repair(Repairable r) {
        if (r instanceof Unit) {
            Unit unit = (Unit) r;
            while (unit.hitPoint != unit.MAX_HP) {
                unit.hitPoint++;
            }
        }
    }

}
