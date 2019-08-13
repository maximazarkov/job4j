package ru.job4j.chess.firuges;

import ru.job4j.chess.exception.*;

public abstract class Figures {
    // TODO по заданию вынес в отдельный абстракный класс только не в Figere, в Figures. Интерфейс Figere пока оставил
    // TODO необходимо спросить у ментора о необходимости оставлять интерфейс.

    // описание шахмотной доски, содержит координаты x,y
    //изменение координат будут проиходить при пересоздании объекта, т.к. Cell - final
    private final Cell position;

    //конструктор
    public Figures(final Cell position) {
        this.position = position;
    }

    //метод, возвращающий позицию
    public Cell position() {
        return this.position;
    }

    protected int chkCource(int source, int dest) {
        return source >= dest ? (source != dest ? 1 : 0) : -1;
    }

    protected Cell checkCell(int x, int y) {
        for (Cell cell : Cell.values()) {
            if (cell.x == x && cell.y == y) {
                //               System.out.println("checkCell: " + cell.x + ", " + cell.y + " - " + cell);
                return cell;
            }
        }
        System.out.println("checkCell is NULL");
        return null;
    }
}
