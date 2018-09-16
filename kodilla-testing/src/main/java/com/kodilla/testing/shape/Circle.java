package com.kodilla.testing.shape;

public class Circle implements Shape {

    double radiusCircle;

    public Circle(double radiusCircle) {
        this.radiusCircle = radiusCircle;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public double getField() {
        return Math.PI * radiusCircle * radiusCircle;
    }
}