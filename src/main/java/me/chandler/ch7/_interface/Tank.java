package me.chandler.ch7._interface;

public class Tank extends GroundUnit implements Repairable{

    public Tank() {
        super(150); // 기본 HP
        hitPoint = MAX_HP;
    }

    @Override
    public void repair(Repairable r) {
        
    }
}
