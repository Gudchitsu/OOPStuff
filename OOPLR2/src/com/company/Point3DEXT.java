package com.company;

public class Point3DEXT extends Point2D {
    private double pointZ;

    public Point3DEXT (double pointX, double pointY, double pointZ) {
        this.xCoord=pointX;
        this.yCoord=pointY;
        this.pointZ=pointZ;
    }

    public Point3DEXT () {
        this (0.0,0.0,0.0);
    }

    public void setPointZ(double pointZ) {
        this.pointZ = pointZ;
    }

    public double getPointZ() {
        return pointZ;
    }
}
