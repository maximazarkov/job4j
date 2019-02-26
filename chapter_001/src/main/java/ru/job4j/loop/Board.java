package ru.job4j.loop;

/**
 * Board - рисует шахматную доску с помощью псевдографики
 * @author Azarkov Maxim
 * @version $Id$
 * @since 0.1 (26.02.2019)
 */
public class Board {

    /**
     * paint - формирует шахматную доску из псевдосимволов Х и пробел
     * @param width - ширина доски
     * @param height - высота доски
     * @return - сформатированная доска
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                // условие проверки, что писать пробел или X
                // Выше в задании мы определили закономерность, когда нужно проставлять X
                if (((i + j) % 2) == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }
}
