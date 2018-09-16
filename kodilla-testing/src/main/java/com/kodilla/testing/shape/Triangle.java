package com.kodilla.testing.shape;

public class Triangle implements Shape {

    double baseTriangle;
    double heightTriangle;

    public Triangle(double baseTriangle, double heightTriangle) {
        this.baseTriangle = baseTriangle;
        this.heightTriangle = heightTriangle;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getField() {
        return 0.5 * baseTriangle * heightTriangle;
    }
}
