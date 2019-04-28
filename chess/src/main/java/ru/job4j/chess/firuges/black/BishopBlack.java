package ru.job4j.chess.firuges.black;

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
public class BishopBlack extends Figures implements Figure {
    public BishopBlack(final Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
//        Cell[] steps = new Cell[0];
        //в замен size логичнее применить route (количество клеток до целевой клетки)
//        int routеX = Math.abs(source.x - dest.x); // по оси Х
//        int routeY = Math.abs(source.y - dest.y); // по оси Y
        int route = Math.abs(source.y - dest.y);    // при движении по диагонали подойдет как X так и Y
        Cell[] steps = new Cell[route];
        if (source.y == dest.y + route && source.x == dest.x + route) {

            for (int i=0; i < steps.length; i++) {
                steps[i] = checkCell(source.x - i - 1, source.y - i - 1);
            }
        } else if (source.y == dest.y + route && source.x == dest.x - route) {
            for (int i=0; i < steps.length; i++) {
                steps[i] = checkCell(source.x + i + 1, source.y - i - 1);
            }
        } else if (source.y == dest.y - route && source.x == dest.x + route) {
            for (int i=0; i < steps.length; i++) {
                steps[i] = checkCell(source.x - i - 1, source.y + i + 1);
            }
        } else if (source.y == dest.y - route && source.x == dest.x - route) {
            for (int i=0; i < steps.length; i++) {
                steps[i] = checkCell(source.x + i + 1, source.y + i + 1);
            }
        } else {
            throw new ImpossibleMoveException("Слон не может двигаться в этом направлении");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
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
