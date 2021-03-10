package com.company;

public class Point3D {
    private double pointX;
    private double pointY;
    private double pointZ;

    public Point3D (double pointX, double pointY, double pointZ) {
        this.pointX=pointX;
        this.pointY=pointY;
        this.pointZ=pointZ;
    }

    public Point3D () {
        this (0.0,0.0,0.0);
    }

 public double getPointX() {
        return pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public double getPointZ() {
        return pointZ;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public void setPointZ(double pointZ) {
        this.pointZ = pointZ;
    }

    public double distanceTo (Point3D anPoint) {
        return  Math.sqrt(Math.pow(anPoint.getPointX()-this.getPointX(),2)+
                Math.pow(anPoint.getPointY()- this.getPointY(),2)+
                Math.pow(anPoint.getPointY()- this.getPointZ(),2) );
    }

}
