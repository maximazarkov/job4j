package ru.job4j.chess.firuges;

import ru.job4j.chess.exception.ImpossibleMoveException;

public class Knight extends Figures {
    public Knight(Cell position) {
        super(position);
    }

    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        int routeY = Math.abs(source.y - dest.y);
        int routeX = Math.abs(source.x - dest.x);
        if ((routeX == 1 && routeY == 2) || (routeY == 1 && routeX == 2)) {
            steps = new Cell[] {dest };
        } else {
            throw new ImpossibleMoveException("Конь не может двигаться в этом направлении");
        }
        return steps;
    }
}
