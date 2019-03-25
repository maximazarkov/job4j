package ru.job4j.pseudo;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * <p>Тестирование отдельных классов Trienglе и Square, реализующих метод draw() интерфеса Paint. Так же выполнено тестирование класса main с реализацией перехвата потока ввода вывод от монитора (консоль) в память. Постле выполнения тестирования поток возвращается консоли.</p>
 *
 * <p>Данный файл с точки зрения рефакторинга составлен абсолютно не правильно, т.к. содержит много  "метрвого" кода, но это сделано намеренно, в целях обучения и понимая задачи. Разделив задачи на классы пропадет возможность получить какие либо коллизии методов.</p>
 *
 * @author Azarkov Maxim
 * @version $Id$
 * @since 0.2
 */
public class SquareTest {

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    // неправильный медот, рекомендуется применять @Before. см. ниже
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    // неправильный медот, рекомендуется применять @After см. ниже.
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Before
    public void loadOutputBefore() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutputAfter() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

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

    /**
     * <p>Данный тест будет реализовавыть некорректный вариант рефакторинга</p>
     * <p>!!! ТАК ДЕЛАТЬ НЕ РЕКОМЕНДУЕТСЯ!!!</p>
     */
    @Test
    public void whenPaintDrawSquare() {
        // получаем ссылку на стандартный вывод в консоль.
 //       PrintStream stdout = System.out;
        // Создаем буфер для хранения вывода.
 //       ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
 //       System.setOut(new PrintStream(out));
        // выполняем действия пишушиее в консоль.
        this.loadOutput();
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

    /**
     * <p>Данный тест реализовавыть правильно, с @Before и @After</p>
     * <p>В данном методе удален метрвый код.</p>
     */
    @Test
    public void whenPaintDrawTriagle() {
        // @Before: public void loadOutputBefore()
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
    }   // @After: public void backOutputAfter()
}
