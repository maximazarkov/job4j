package ru.job4j.abstractFactory;

import ru.job4j.factory.shapes.RectangleShape;
import ru.job4j.factory.shapes.TriangleShape;

public interface ShapeAbstFactory {
    TriangleShape createTreangleShape();

    RectangleShape createRectangleShape();
}
