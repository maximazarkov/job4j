package ru.job4j.condition;

/**
 * Point.
 * @author Maxim Azarkov (aza-maxim@yandex.ru).
 * @version $Id$.
 * @since 0.1 (23.02.2019).
 */
public class Point {
    private int x;
    private int y;

    /**
     * Point.constructor
     * @param x - x ordinate.
     * @param y - y ordinate.
     * @since 0.1 (23.02.2019).
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * distanceTo - расчет дистации между точками A(x,y) и B(x,y)
     * @param that - point X(x,y).
     * @return - расстояни между точкой A(x,y) и B(x,y)/
     * @since 0.1 (23.02.2019).
     */
    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2));
    }

    /**
     * main.
     * @param args - args.
     * @since 0.1 (23.02.2019).
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        // сделаем вывод на консоль
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);
        double result = a.distanceTo(b);
        System.out.println("расстояние между точками A и Б: " + result);
    }
}
