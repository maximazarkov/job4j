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

//    @Override
//    public Cell[] way(Cell source, Cell dest) {
//        //в замен size логичнее применить route (количество клеток до целевой клетки)
//        int routeX = source.x - dest.x; // по оси Х
//        int routeY = source.y - dest.y; // по оси Y
//        int courceX = chkCource(routeX);
//        int courceY = chkCource(routeY);
//        Cell[] steps = new Cell[Math.abs(routeX)];// при движении по диагонали подойдет как X так и Y
//
////        if (!isDiagonal(source, dest)) {
////            throw ...
////        }
//        if (Math.abs(routeX) == Math.abs(routeY)){
//            for (int i=0; i < steps.length; i++) {
//                steps[i] = checkCell(   source.x - courceX * i - courceX * 1,
//                                        source.y - courceY * i - courceY * 1);
//            }
//        } else {
//            throw new ImpossibleMoveException("Слон не может двигаться в этом направлении");
//        }
//
//        return steps;
//    }

//    private int chkCource(int cource) {
//        return cource < 0 ? -1 : 1;
//    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

//    public Cell checkCell(int x, int y) {
//        for (Cell cell : Cell.values()) {
//            if (cell.x == x && cell.y == y) {
//                System.out.println("checkCell: " + cell.x + ", " + cell.y + " - " + cell);
//                return cell;
//            }
//        }
//        System.out.println("checkCell is NULL");
//        return null;
//    }
}
