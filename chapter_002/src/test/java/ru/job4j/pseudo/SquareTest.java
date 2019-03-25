package ru.job4j.pseudo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование отдельных классов Trienglе и Square, реализующих метод draw() интерфеса Paint. Так же выполнено тестирование класса main с реализацией перехвата потока ввода вывод от монитора (консоль) в память. Постле выполнения тестирования поток возвращается консоли.
 *
 * @author Azarkov Maxim
 * @version $Id$
 * @since 0.1
 */
public class SquareTest {

    @Test
    public void whenDrawSquare() {
        Square sq = new Square();
        assertThat(sq.draw(), is(new StringBuilder()
                .append("+---+")
                .append(System.lineSeparator())
                .append("|   |")
                .append(System.lineSeparator())
                .append("|   |")
                .append(System.lineSeparator())
                .append("|   |")
                .append(System.lineSeparator())
                .append("+---+")
                .append(System.lineSeparator())
                .toString()));
    }

    @Test
    public void whenDrawTriangle() {
        Triangle tr = new Triangle();
        assertThat(tr.draw(), is(new StringBuilder()
                .append("    +    ")
                .append(System.lineSeparator())
                .append("   / \\   ")
                .append(System.lineSeparator())
                .append("  /   \\  ")
                .append(System.lineSeparator())
                .append(" /     \\ ")
                .append(System.lineSeparator())
                .append("+-------+")
                .append(System.lineSeparator())
                .toString()));
    }

    @Test
    public void whenPaintDrawSquare() {
        // получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        // Создаем буфер для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
        // выполняем действия пишушиее в консоль.
        new Paint().draw(new Square());
        // проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("+---+")
                                .append(System.lineSeparator())
                                .append("|   |")
                                .append(System.lineSeparator())
                                .append("|   |")
                                .append(System.lineSeparator())
                                .append("|   |")
                                .append(System.lineSeparator())
                                .append("+---+")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .toString())
        );
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }

    @Test
    public void whenPaintDrawTriagle() {
        // получаем ссылку на стандартный вывод в консоль
        PrintStream stdout = System.out;
        //создаем буфер для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // заменяем стандартный вывод на вывод в память для тестирования.
        System.setOut(new PrintStream(out));
        // выполняем действия пишушие в консоль.
        new Paint().draw(new Triangle());
        // проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("    +    ")
                                .append(System.lineSeparator())
                                .append("   / \\   ")
                                .append(System.lineSeparator())
                                .append("  /   \\  ")
                                .append(System.lineSeparator())
                                .append(" /     \\ ")
                                .append(System.lineSeparator())
                                .append("+-------+")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }
}
