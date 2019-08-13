package ru.job4j.chess.firuges;

import ru.job4j.chess.exception.ImpossibleMoveException;

public class Queen extends Figures {
    public Queen(Cell position) {
        super(position);
    }

    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        int routeY = Math.abs(source.y - dest.y);
        int routeX = Math.abs(source.x - dest.x);
        int courceX = chkCource(source.x, dest.x);
        int courceY = chkCource(source.y, dest.y);
        if (routeY == routeX || (routeX != 0 && routeY == 0) || (routeX == 0)) {
//        if (routeY == routeX || (routeX != 0 && routeY == 0) || (routeY != 0 && routeX == 0)) {
            steps = new Cell[Math.abs(routeX >= routeY ? routeX : routeY)];
            for (int i = 0; i < steps.length; i++) {
                steps[i] = checkCell(source.x - courceX * i - courceX,
                        source.y - courceY * i - courceY);
            }
        } else {
            throw new ImpossibleMoveException("Ферзь не может двигаться в этом направлении");
        }
        return steps;
    }
}
