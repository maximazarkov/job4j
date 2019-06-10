package ru.job4j.chess;

import ru.job4j.chess.exception.*;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure; // цепляемся к интерфесу

import java.util.Optional;

/**
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

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean rst = false;                 // флаг возможности перемещения фигуры
        int index = this.findBy(source);     // проверим, что фигура существует и сравнима позицию. при ошибке получим -1
        int destination = this.findBy(dest); // проверим, что место назначения доступно
        try {
            if (index != -1) {
                // получим массив ячеек пути перемезания фигуры
                Cell[] steps = this.figures[index].way(source, dest);
                for (int step = 0; step < steps.length; step++) {
                    int empty = findBy(steps[step]);
                    //System.out.println("Logic: source: " + source + ", destination: " + destination + ", empty: " + empty);
                    if (empty != -1 || destination != -1) {
                        throw new OccupiedWayException("Данная клетка занята");
                    }

                    // Если нас все устраивает, то переместим фигуру простым копироанием, иначе оставляем фигуру на месте
                    if (steps.length > 0 && steps[step].equals(dest)) {
                        rst = true;
                        this.figures[index] = this.figures[index].copy(dest);
                    }
                }
            } else {
                throw new FigureNotFoundException("В этой клетке нет фигур");
            }
        //перехватим исключения ImpossibleMoveException и OccupiedWayException
        // в методе Logic, т.к. если перехватить исключения в методе классе Chess,
        // то будут артефакты при проресовке фигур - они перестанут привязываться к сетке
        } catch (ImpossibleMoveException ime) {
            System.out.println(ime.getMessage());
        } catch (OccupiedWayException owe) {
            System.out.println(owe.getMessage());
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
