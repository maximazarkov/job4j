package ru.job4j.chess.firuges;

import ru.job4j.chess.exception.ImpossibleMoveException;

public abstract class Bishop extends Figures {
    public Bishop(Cell position) {
        super(position);
    }

    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        int routeY = Math.abs(source.y - dest.y);   //int routeX = source.x - dest.x; // по оси Х
        int routeX = Math.abs(source.x - dest.x);   //int routeY = source.y - dest.y; // по оси Y
        int courceX = chkCource(source.x, dest.x);
        int courceY = chkCource(source.y, dest.y);
        steps = new Cell[routeX];// при движении по диагонали подойдет как X так и Y
        if (routeX == routeY){
            for (int i=0; i < steps.length; i++) {
                steps[i] = checkCell(   source.x - courceX * i - courceX,
                        source.y - courceY * i - courceY);
            }
        } else {
            throw new ImpossibleMoveException("Слон не может двигаться в этом направлении");
        }

        return steps;
    }
}
