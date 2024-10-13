package me.chandler.ch7;

public class Point3D extends Point {

    int z;

    public Point3D() {
//        super(); // 호출시
        this(0, 0, 0);
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}
