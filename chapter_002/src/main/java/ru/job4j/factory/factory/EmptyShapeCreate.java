package ru.job4j.factory.factory;

import ru.job4j.factory.shapes.EmptyShape;
import ru.job4j.factory.shapes.Shape;

public class EmptyShapeCreate extends ShapeFactory {

    @Override
    public Shape createShape() {
        return new EmptyShape();
    }
}
