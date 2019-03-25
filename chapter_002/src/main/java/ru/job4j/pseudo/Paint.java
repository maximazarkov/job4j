package ru.job4j.pseudo;

public class Paint {

    private Shape shape;

    // setter & execute in one method
    public void draw(Shape shape) {
        this.shape = shape;                 //setter
        System.out.println(shape.draw());   //execute
    }


}
