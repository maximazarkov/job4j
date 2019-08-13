package ru.job4j.factory;

import ru.job4j.abstractfactory.ShapeAbstFactory;
import ru.job4j.abstractfactory.ShapeAbstFactoryCreater;
import ru.job4j.factory.factory.EmptyShapeCreate;
import ru.job4j.factory.factory.RectangleCreate;
import ru.job4j.factory.factory.ShapeFactory;
import ru.job4j.factory.factory.TriangleCreate;
import ru.job4j.factory.shapes.Shape;

public class Shapes {

    private static ShapeAbstFactory abstFactory;

    public Shapes(ShapeAbstFactory abstFactory) {
        this.abstFactory = abstFactory;
    }

    public static void main(String[] args) {
        ShapeFactory shapeFactory;
        Shape shape;

        shapeFactory = createShapeByType("cycle");
        shape = shapeFactory.createShape();
        shape.printShape();

        shapeFactory = createShapeByType("triangle");
        shape = shapeFactory.createShape();
        shape.printShape();

        shapeFactory = createShapeByType("rectangle");
        shape = shapeFactory.createShape();
        shape.printShape();

        new Shapes(new ShapeAbstFactoryCreater());
        shape = abstFactory.createRectangleShape();
        shape.printShape();
        shape = abstFactory.createTreangleShape();
        shape.printShape();
    }

    static ShapeFactory createShapeByType(String name) {
        ShapeFactory shape = new EmptyShapeCreate();
        if ("triangle".equals(name)) {
            shape = new TriangleCreate();
        } else if ("rectangle".equals(name)) {
            shape = new RectangleCreate();
        }
        return shape;

    }


}
