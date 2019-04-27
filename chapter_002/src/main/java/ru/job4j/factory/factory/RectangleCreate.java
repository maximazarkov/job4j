package ru.job4j.factory.factory;

import ru.job4j.factory.shapes.RectangleShape;
import ru.job4j.factory.shapes.Shape;

public class RectangleCreate extends ShapeFactory {

    @Override
    public Shape createShape() {
        return new RectangleShape();
    }
}
