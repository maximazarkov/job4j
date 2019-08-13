package ru.job4j.chess.firuges;

import ru.job4j.chess.exception.ImpossibleMoveException;

public class King extends Figures {
    public King(Cell position) {
        super(position);
    }

    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        int routeY = Math.abs(source.y - dest.y);
        int routeX = Math.abs(source.x - dest.x);
        if ((routeY == 1 || routeY == 0) && (routeX == 1 || routeX == 0)) {
            steps = new Cell[] {
                    dest
            };
        } else {
            throw new ImpossibleMoveException("Король не может двигаться в этом направлении");
        }
        return steps;
    }
}
