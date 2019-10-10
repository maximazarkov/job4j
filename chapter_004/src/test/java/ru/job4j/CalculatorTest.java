package ru.job4j;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAdd1Until3() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(
                0, 3, 1,
                MathUtil::add,  // static call
                buffer::add     // non-static call
        );
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }


//1. Реализовать метод подсчета функции в диапазоне.
//        List<Double> diapason(int start, int end, Function<Double, Double> func);
//        2. Реализации функций в тестах.
//        - линейная.
//        - квадратичная.
//        - логарифмическая.
//        3. Необходимо использовать только встроенные функциональные интерфейсы
    @Test
    public void whenLinearFunctionThenLinearResults() {
//        Calculator function = new Calculator();
        List<Double> result = Calculator.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenQuadraticResults() {
        // Идея предложила напрямую обратиться к статическому методоку без создания экземпляра сласса
//        Calculator function = new Calculator();
        // протестируем определенную формулу f(x) = 1 * x^2 + (-8) * x * 15
        double a = 1;
        double b = -8;
        double c = 15;
        List<Double> result = Calculator.diapason(5, 8, x -> a * x * x + b * x + c);
        List<Double> expected = Arrays.asList(0D, 3D, 8D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenLogResults() {
        // переберем логарифм по основанию 2 в диапазоне от 4 до 8
        double a = 2;
        List<Double> result = Calculator.diapason(4, 9, x -> Math.log(x) / Math.log(a));
        List<Double> expected = Arrays.asList(2D, 2.321928094887362D, 2.584962500721156D, 2.807354922057604D, 3D);
        assertThat(result, is(expected));
    }
}