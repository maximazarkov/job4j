package ru.job4j.coffeeMachine;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.CoreMatchers.not;

/*
* test whenCoffeePriceGtValueAssertJСatchThrowable() не удалось запустить из-за непонятной ошибки import
*/
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.catchThrowable;

/*
 * test whenCoffeePriceGtValueJupiter() не удалось запустить из-за непонятной ошибки import
 */
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;



public class coffeeMachineTest {

    @Test
    public void whenCoffeeNx11Pay100ThenChange100MinesNx11() {
        Change ch = new Change();
        int[] change = ch.change(11, 100);
        int[] result = {10, 10, 10, 10, 10, 10, 10, 10, 5, 2, 2};
        assertThat(result, is(change));
        change = ch.change(22, 100);
        result = new int[]{10, 10, 10, 10, 10, 10, 10, 5, 2, 1};
        assertThat(result, is(change));
        change = ch.change(33, 100);
        result = new int[]{10, 10, 10, 10, 10, 10, 5, 2};
        assertThat(result, is(change));
        change = ch.change(44, 100);
        result = new int[]{10, 10, 10, 10, 10, 5, 1};
        assertThat(result, is(change));
        change = ch.change(55, 100);
        result = new int[]{10, 10, 10, 10, 5};
        assertThat(result, is(change));
        change = ch.change(66, 100);
        result = new int[]{10, 10, 10, 2, 2};
        assertThat(result, is(change));
        change = ch.change(77, 100);
        result = new int[]{10, 10, 2, 1};
        assertThat(result, is(change));
        change = ch.change(88, 100);
        result = new int[]{10, 2};
        assertThat(result, is(change));
        change = ch.change(99, 100);
        result = new int[]{1};
        assertThat(result, is(change));

// тест по заданию
        change = ch.change(35, 50);
        result = new int[]{10, 5};
        assertThat(result, is(change));
    }

    /**
     * Ниже будут приведены несколько тестов по проверке Exception. Тесты приведены вкачестве примеров
     * для демонстрации недостатков и достоинств указанных методов
     * <p>
     * 1. @Test (expected)
     *
     * @throws NegativeArraySizeException - ловим Exception, если денет на кофе не хватает
     * @deprecated - НЕ РЕКОМЕНДОВАННО К ПРИМЕНЕНИЮ ИЗ-ЗА ВТОРОГО ИЗ НЕДОСТАТКА
     * <p>
     * Параметр expected в аннотации @Test - cамый простой способ сообщить тестовому фреймворку о том,
     * что ожидается исключени NegativeArraySizeException.class
     * <p>
     * Этот параметр должен содержать тип ожидаемого исключения. Если возникнет исключение именно
     * такого типа – тест пройдёт успешно. Если возникнет исключение другого типа или не возникнет
     * вовсе – тест упадёт.
     * <p>
     * Достоинства:
     * *Простота и краткость.
     * <p>
     * Недостатки:
     * * Нельзя проверить текст сообщения или другие свойства возникшего исключения.
     * * Нельзя понять, где именно возникло исключение. В рассматриваемом примере оно могло быть выброшено
     * не тестируемой функцией, а чуть раньше, при попытке создать временную директорию. Тест даже не смог
     * добраться до вызова тестируемой функции – но при этом в отчёте он помечается как успешно пройденный!
     */
    @Test(expected = NegativeArraySizeException.class)
    public void whenCoffeePriceGtValueTestExpected() throws NegativeArraySizeException {
        Change ch = new Change();
        int[] change = ch.change(55, 50);
        int[] result = new int[]{10, 10, 10, 10, 10, 5};
        assertThat(result, is(change));
    }

    /**
     * 2. try-catch - более стабильный чем @Test (expected)
     * <p>
     * Оба недостатка из предыдущего примера можно устранить, если перехватывать исключение явно
     * при помощи конструкции try-catch:
     * <p>
     * Если исключение возникает до блока try – тест падает, мы узнаём о том, что у него возникли проблемы.
     * Если тестируемая функция не выбрасывает вообще никакого исключения – мы попадаем на fail()
     * в следующей строке, тест падает.
     * Если она выбрасывает исключение неподходящего типа – блок catch не ловит его, тест опять таки падает.
     * Успешно он завершается только тогда, когда тестируемая функция выбрасывает исключение нужного типа.
     * Тест стал более надёжным, он больше не пропускает баги. А в блоке catch можно проверить свойства
     * пойманного исключения.
     *
     * @throws NegativeArraySizeException - ловим Exception, если денет на кофе не хватает
     */
    @Test
    public void whenCoffeePriceGtValueTryCatch() throws NegativeArraySizeException {
        Change ch = new Change();
        try {
            int[] change = ch.change(55, 50);
            int[] result = new int[]{10, 10, 10, 10, 10, 5};
            assertThat(result, is(change));

        } catch (NegativeArraySizeException nase) {
            Assert.assertNotEquals("", nase.getMessage());
        }
    }

    /**
     * 3. @Rule
     * <p>
     * Чтобы избавиться от неудобства конструкции try-catch, можно воспользоваться
     * правилом ExpectedException, ходящим в стандартный дистрибутив JUnit 4:
     * <p>
     * Теперь код имеет простую плоскую структуру, хотя общее количество строк кода, к сожалению, увеличилось.
     * Но главная проблема этого способа заключается в том, что проверки в таком стиле выглядят
     * противоестественно – сначала описывается поведение, а потом вызывается функция.
     * Примедение данного метода - дело личных предпочтений, но рекомендуется другой подход,
     * когда проверки располагаются после вызова тестируемой функции.
     *
     * @throws NegativeArraySizeException - ловим Exception, если денет на кофе не хватает
     */

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void whenCoffeePriceGtValueRule() throws NegativeArraySizeException {
        Change ch = new Change();
        thrown.expect(NegativeArraySizeException.class);
        thrown.expectMessage(not(equalTo("")));
        int[] change = ch.change(55, 50);
        int[] result = new int[]{10, 10, 10, 10, 10, 5};
        assertThat(result, is(change));
        thrown = ExpectedException.none();
    }

    /**
     * @deprecated - данный дест не удалось запустить изза ошибки в import
     *
     * 4. AssertJ / catch-throwable
     *
     * Более красивый способ, использующий возможности Java 8, предлагают дополнительные библиотеки,
     * такие как AssertJ или catch-throwable. Ниже приведен пример работы с AssertJ.
     *
     * Обращение к тестирумой функции оформлено в виде лямбда-выражения (анонимной функции),
     * которое передаётся в “ловушку” для исключений catchThrowable. Она перехватывает возникающее
     * исключение и возвращает его как результат своей работы, давая возможность сохранить его
     * в переменную и затем проверить его свойства. При этом проверки находятся после вызова
     * тестируемой функции, читать код легче.
     *
     * А если исключение не возникнет – “ловушка” сама выбросит исключение и тест упадёт.
     *
     * @throws NegativeArraySizeException  - ловим Exception, если денет на кофе не хватает
     */
//    @Test
//    public void whenCoffeePriceGtValueAssertJСatchThrowable() throws NegativeArraySizeException {
//        Change ch = new Change();
//        Throwable thrown = catchThrowable(() -> {
//
//        });
//        int[] change = ch.change(55, 50);
//        int[] result = new int[]{10, 10, 10, 10, 10, 5};
//        assertThat(result, is(change));
//    }

    /**
     * @deprecated - данный дест не удалось запустить изза ошибки в import
     *
     * 5. JUnit 5
     *
     * Перехват исключений в JUnit 5 выглядит очень похоже на предыдущий пример (который не пошел):
     *
     * Раньше такая возможность в JUnit отсутствовала, потому что предыдущие версии JUnit были
     * ориентированы на более старые версии Java, где не было лямбда-выражений и написать
     * подобный код было просто невозможно. Да, можно сделать нечто подобное с помощью анонимных
     * классов, но это выглядит настолько ужасно, что конструкция try-catch кажется верхом изящества.
     *
     * Так что если вам приходится писать тесты, в которых проверяется возникновение
     * исключений – есть повод присмотреться к новым возможностям JUnit 5.
     */

//    @Test
//    public void whenCoffeePriceGtValueJupiter() throws NegativeArraySizeException {
//        Change ch = new Change();
//        thrown.expect(NegativeArraySizeException.class);
//        thrown.expectMessage(not(equalTo("")));
//        int[] change = ch.change(55, 50);
//        int[] result = new int[]{10, 10, 10, 10, 10, 5};
//        assertThat(result, is(change));
//        thrown = ExpectedException.none();
//    }
}