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

    // метод, проверяет возможность перехода фигуры на местно назначения. dest - задает ячейку, куда следует пойти
    //Если фигура туда может пойти, то вернуть массив ячеек, которые должна пройти фигура.
    //Если фигура не может пройти к цели (target), то выбросить исключение ImpossibleMoveException
    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;


}
