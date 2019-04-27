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

    /*
    * //TODO
    * Bishop умеет ходить только на одну клетку по диагонали.
    * необходимо придумать, как он сможт прыгать на массив влеток,
    * т.е. если прыжок будет более чем на одну клетку.
    * */

    /*
    * TODO
    *  Движение слона происходит по диагонали.
Мы знаем начальную и конечную точку движения фигуры. По этим координатам мы можем понять движется ли слон по диагонали.
if (!isDiagonal(source, dest)) {
   throw ...
}
Если он находиться на диагонали. то мы может вычислить дельты шагов.
Слон может двигаться в четыре стороны. Эти движения можно описать двумя дельтами +1 -1.
Например. если слон двигается вниз влево, то дельты будет -1 -1.
Cell[] steps = new Cell[size];
int deltaX = ...
int deltaY = ...;
for (.... ) {
    steps[index] = ...
}
return steps;
То есть метод Cell[] move(Cell source, Cell dest) - максимум будет занимать 10 строк кода. Ты можешь себя сам проверить по этому условию.
По завершению проекта шахматы сделай пост в социальной сети про это приложение. По аналогии с задачей крестики нолики.
    * */
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
        } else {
            throw new ImpossibleMoveException("Слон не может двигаться в этом направлении");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
