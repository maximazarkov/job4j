package ru.job4j.abstractfactory;

import ru.job4j.factory.shapes.RectangleShape;
import ru.job4j.factory.shapes.TriangleShape;

public interface ShapeAbstFactory {
    TriangleShape createTreangleShape();

    RectangleShape createRectangleShape();
}
