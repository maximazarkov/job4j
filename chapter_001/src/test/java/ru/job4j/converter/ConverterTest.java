package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.convert
 */
public class ConverterTest {

    /**
     * Test.convert.rubleToEuro.
     */
    @Test
    public void when140RubleThen2Euro() {
        //Определяем ввод данных
        int input = 140;
        // определяем ожидаемый результат (или поведение)
        int expect = 2;
        //Составление списка действий и сценария. После выполния будет произведено какое-то действие, изменено состояние программы, либо выведено результат
        Converter conv = new Converter();
        int result = conv.rubleToEuro(input);
        //завершающий этап. Сравнение реального и ожидаемого резальтатов программы
        assertThat(result, is(expect));
    }

    /**
     * Test.convert.rebleToDollar.
     */
    @Test
    public void when180RubleThen3Dollar() {
        int input = 180;
        int expect = 3;
        Converter conv = new Converter();
        int result = conv.rubleToDollar(input);
        assertThat(result, is(expect));
    }

    /**
     * Test.conver.EuroToRuble.
     */
    @Test
    public void when2EuroThen140Ruble() {
        int input = 2;
        int expect = 140;
        Converter conv = new Converter();
        int result = conv.euroToRuble(input);
        assertThat(result, is(expect));
    }

    /**
     * Test.convert.DollarToRuble
     */
    @Test
    public void when2DollsrThen120ruble() {
        int input = 2;
        int expect = 120;
        Converter conv = new Converter();
        int result = conv.dollarToRuble(input);
        assertThat(result, is(expect));
    }
}
