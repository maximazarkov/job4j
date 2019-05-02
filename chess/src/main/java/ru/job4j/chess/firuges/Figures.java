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
//    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;
    public Cell[] way(Cell source, Cell dest) {
        //в замен size логичнее применить route (количество клеток до целевой клетки)
        int routeX = source.x - dest.x; // по оси Х
        int routeY = source.y - dest.y; // по оси Y
        int courceX = chkCource(routeX);
        int courceY = chkCource(routeY);
        Cell[] steps = new Cell[Math.abs(routeX)];// при движении по диагонали подойдет как X так и Y

//        if (!isDiagonal(source, dest)) {
//            throw ...
//        }
        if (Math.abs(routeX) == Math.abs(routeY)){
            for (int i=0; i < steps.length; i++) {
                steps[i] = checkCell(   source.x - courceX * i - courceX * 1,
                        source.y - courceY * i - courceY * 1);
            }
        } else {
            throw new ImpossibleMoveException("Слон не может двигаться в этом направлении");
        }

        return steps;
    }

    private int chkCource(int cource) {
        return cource < 0 ? -1 : 1;
    }

    public Cell checkCell(int x, int y) {
        for (Cell cell : Cell.values()) {
            if (cell.x == x && cell.y == y) {
                System.out.println("checkCell: " + cell.x + ", " + cell.y + " - " + cell);
                return cell;
            }
        }
        System.out.println("checkCell is NULL");
        return null;
    }
}
