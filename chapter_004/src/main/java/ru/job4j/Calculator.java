package ru.job4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Calculator {

    /**
     * по причине применение встроенных функциональных интерфесов, интерфес Operation стал не востребован
     * @deprecated
     */
    public interface Operation {
        double calc(int left, int right);
    }

    /**
     * Пример применения встроенных функциональных интерфесов
     *
     * @param start - начальное значние из множества.
     * @param finish - конечное значение из множества
     * @param value - значение на которе
     * @param op
     * @param media
     */
    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    public static List<Double> diapason(int start, int end,
                                        Function<Double, Double> func) {
        List<Double> buffer = new ArrayList<>();
        for (double index = start; index != end; index++) {
            buffer.add(func.apply(index));
        }
        return buffer;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(
                0, 10, 2,
                MathUtil::add,
                System.out::println
        );
    }
}
