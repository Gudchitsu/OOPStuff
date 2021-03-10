package com.company;

public class Point2D {

    protected double xCoord;
    protected double yCoord;

    public Point2D ( double x, double y) {
        xCoord = x;
        yCoord = y;
    }

    public Point2D () {
//Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0);
    }

    public double getX () {
        return xCoord;
    }

    public double getY () {
        return yCoord;
    }

    public void setX ( double val) {
        xCoord = val;
    }

    public void setY ( double val) {
        yCoord = val;
    }
}

