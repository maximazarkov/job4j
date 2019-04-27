package ru.job4j.chess;

import ru.job4j.chess.exception.*;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure; // цепляемся к интерфесу

import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }


    /*
    * TODO
    *  8. Метод должен проверить
   - Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
   - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
   - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
   - Если все отлично. Записать в ячейку новое новое положение Figure figure.copy(Cell dest)
    * */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        // TODO необходимо подроблее разобраться с логикой и переписать комментарии
        // предварительное описание логики шахмат
        boolean rst = false;                 // влаг возможности перемещения фигуры
        int index = this.findBy(source);     // проверим, что фигура существует и сравнима позицию. при ошибке получим -1
//        int destination = this.findBy(dest); // проверим, что ...  -1
//        if (index != -1 && destination != -1) { // убедимся, что мы можем переместить фигуру
        if (index != -1) { // вренулся к начальной реализаци на время
            // получим массив ячеек от
            Cell[] steps = this.figures[index].way(source, dest);
            // Если нас все устраивает, то переместим фигуру простым копирвоанием, иначе оставляем фигуру на месте
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst; // если фигура перенесена, возвращаем true.
    }

    // метод удаления фигуры после переноса/удаления с поля.
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
