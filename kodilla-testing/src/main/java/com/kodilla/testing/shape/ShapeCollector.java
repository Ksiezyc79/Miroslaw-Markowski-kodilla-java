package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    public ArrayList<Shape> listShape = new ArrayList<Shape>();

    public void addFigure (Shape shape) {
        listShape.add(shape);
    }

    public boolean removeFigure (Shape shape) {
       return listShape.remove(shape);
    }

    public Shape getFigure (int n) {
        return listShape.get(n);
    }

    public void showFigures() {
        System.out.println("Number of elements :" + listShape.size());
        for (Shape shape : listShape) {
            System.out.println("Showing : " + shape.getShapeName());
        }
    }
}