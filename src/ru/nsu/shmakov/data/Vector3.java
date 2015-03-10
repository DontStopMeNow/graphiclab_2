package ru.nsu.shmakov.data;

/**
 * Created by kyb1k on 09.03.15.
 */
public class Vector3 {
    public double x = 0;
    public double y = 0;
    public double z = 0;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void add(Vector3 another) {
        x += another.getX();
        y += another.getY();
        z += another.getZ();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
