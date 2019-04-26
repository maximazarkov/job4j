package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.Figures;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KnightWhite extends Figures implements Figure {
    public KnightWhite(final Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (source.y == dest.y + 2 && source.x == dest.x + 1) {
            steps = new Cell[] {dest };
        } else if(source.y == dest.y + 2 && source.x == dest.x - 1) {
            steps = new Cell[] {dest };
        } else if (source.y == dest.y - 2 && source.x == dest.x + 1) {
            steps = new Cell[]{dest};
        } else if(source.y == dest.y - 2 && source.x == dest.x - 1) {
            steps = new Cell[] {dest };
        } else  if (source.y == dest.y + 1 && source.x == dest.x + 2) {
            steps = new Cell[] {dest };
        } else if(source.y == dest.y - 1 && source.x == dest.x + 2) {
            steps = new Cell[] {dest };
        } else if (source.y == dest.y + 1 && source.x == dest.x - 2) {
            steps = new Cell[]{dest};
        } else if(source.y == dest.y - 1&& source.x == dest.x - 2) {
            steps = new Cell[] {dest };
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
    }
}
