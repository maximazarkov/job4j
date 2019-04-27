package ru.job4j.chess.firuges.white;

import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.Figures;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KingWhite extends Figures implements Figure {
    public KingWhite(final Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (source.y == dest.y + 1 && source.x == dest.x + 1) {
            steps = new Cell[] { dest };
        } else if (source.y == dest.y + 1 && source.x == dest.x - 1) {
            steps = new Cell[] { dest };
        } else if (source.y == dest.y - 1 && source.x == dest.x + 1) {
            steps = new Cell[] { dest };
        } else if (source.y == dest.y - 1 && source.x == dest.x - 1) {
            steps = new Cell[] { dest };
        } else if (source.y == dest.y + 1 && source.x == dest.x) {
            steps = new Cell[] { dest };
        } else if (source.y == dest.y && source.x == dest.x + 1) {
            steps = new Cell[] { dest };
        } else if (source.y == dest.y - 1 && source.x == dest.x) {
            steps = new Cell[] { dest };
        } else if (source.y == dest.y && source.x == dest.x - 1) {
            steps = new Cell[] { dest };
        } else {
            throw new ImpossibleMoveException("Король не может двигаться в этом направлении");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingWhite(dest);
    }
}
