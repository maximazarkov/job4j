package ru.job4j.factory.factory;

import ru.job4j.factory.shapes.TriangleShape;
import ru.job4j.factory.shapes.Shape;

public class TriangleCreate extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new TriangleShape();
    }
}
