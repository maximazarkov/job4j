package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


/**
 * Test.Point.
 * @author Maxim Azarkov (aza-maxim@yandex.ru).
 * @version $Id$.
 * @since 0.1 (24.02.2019).
 */
public class PointTest {

    /**
     * Test.Point.distanceTo.
     * @author Maxim Azarkov (aza-maxim@yandex.ru).
     * @since 0.1 (24.02.2019).
     */
    @Test
    public void testDistanceToPointA01andB05is4() {
        Point a = new Point(0, 1);
        Point b = new Point(0, 5);
        double expect = 4D;
        double result = a.distanceTo(b);
        assertThat(expect, closeTo(result, 0.1));
    }

    /**
     * Test add.
     */
    /*public void when...Then... () {}*/
    @Test
    public void whenAddOneToOneThenTwo() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Point.main(null);
        assertThat(
                out.toString(),
                is(
                        String.format(
                                "x1 = 0\r\ny1 = 1\r\nx2 = 2\r\ny2 = 5\r\nрасстояние между точками A и Б: 4.47213595499958\r\n",
                                System.getProperty("line.separator")

                        )
/* Валидация ругается на .format. Пока по не понятным мне причинам. Test проходит успешно
* ошибка на синтаксис format.
* Для эксперимента, оставил только текст, аргумент system.get...  закоментарил, удалил запятую.
* Ошибка и изменилась, Idea предложила применить PrintStream
* Попробовал добавить рекомендуе подсказка при закоментаренной стровке System.get...
* без успешно. При использоваении PrintStream выдается ошибка отсуттвия подключенной соотвествующей библиотеки
* Так же отключается обращение к библиотеке hamcrest, что как я понимаю - неверное решение...
* пример кода, который пока не пошел.
*/
//                        PrintStream.print(
//                                "x1 = 0\r\ny1 = 1\r\nx2 = 2\r\ny2 = 5\r\nрасстояние между точками A и Б: 4.47213595499958\r\n"
//                                System.getProperty("line.separator")
//                        )
                )
        );
    }
}