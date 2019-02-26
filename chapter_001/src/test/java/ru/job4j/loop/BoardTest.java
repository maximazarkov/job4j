package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BoardTest {
    @Test
    public void when3x3() {
        Board board = new Board();
        String rsl = board.paint(3, 3);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("X X%s X %sX X%s", ln, ln, ln)
                )
        );
    }

    @Test
    public void when5x3() {
        Board board = new Board();
        String rsl = board.paint(5, 3);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("X X%s X %sX X%s X %sX X%s", ln, ln, ln, ln, ln)
                )
        );
    }

    @Test
    public void when3x5() {
        Board board = new Board();
        String rsl = board.paint(4, 5);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("X X X%s X X %sX X X%s X X %s", ln, ln, ln, ln)
                )
        );
    }}
