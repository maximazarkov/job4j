package ru.job4j.abstractfactory;

import ru.job4j.factory.shapes.RectangleShape;
import ru.job4j.factory.shapes.TriangleShape;

public class ShapeAbstFactoryCreater implements ShapeAbstFactory {

    @Override
    public TriangleShape createTreangleShape() {
        return new TriangleShape();
    }

    @Override
    public RectangleShape createRectangleShape() {
        return new RectangleShape();
    }
}
