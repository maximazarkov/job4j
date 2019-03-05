package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Paint - рисуетпсевдографику - пирамиду
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Paint {

    /**
     * private loopBy  - метод отрисовки
     * @param height - ширина пирамиды
     * @param widht - высота пирамиды
     * @param predict - лябда выражение задающее порядок прорисовки пирамиды
     * @return - результат прорисовки String
     */
    private String loopBy(int height, int widht, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != widht; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * rightTrl - отрисовывем правую сторону пирамиды
     * @param height - ширина пирамиды вправо
     * @return - отрисованная правая сторона пирамиды
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * leftTrl - отрисовывем левую сторону пирамиды
     * @param height - ширина пирамиды влево
     * @return - отрисованная правая сторона пирамиды
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * pyramid - метод отрисовывающий полную пирамиду (во всю ширину)
     * @param height - ширина всей пирамиды
     * @return - отрисованная вся пирамиды
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }
}