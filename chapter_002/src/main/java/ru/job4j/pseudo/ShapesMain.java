package ru.job4j.pseudo;

public class ShapesMain {

    /**
     * Реализация паттерна Стратегия. на примете двух классов, реализующих методы интерфеса.
     *
     * @author Azarkov Maxim.
     * @param args - программа не обрабатываем парамеры.
     * @since 0.1.
     */
    public static void main(String[] args) {
        //Paint paint = new Paint();
        //paint.draw(new Triangle());
        //paint.draw(new Square());

        new Paint().draw(new Triangle());
        new Paint().draw(new Square());
    }
}
