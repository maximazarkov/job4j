package ru.job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean isWinner(Predicate<Figure3T> predicate) {
        return this.fillBy(predicate, 0, 0, 1, 0)
                || this.fillBy(predicate, 0, 1, 1, 0)
                || this.fillBy(predicate, 0, 2, 1, 0)
                || this.fillBy(predicate, 0, 0, 0, 1)
                || this.fillBy(predicate, 1, 0, 0, 1)
                || this.fillBy(predicate, 2, 0, 0, 1)
                || this.fillBy(predicate, 0, 0, 1, 1)
                || this.fillBy(predicate, this.table.length - 1, 0, -1, 1);
    }

    public boolean isWinnerX() {
        return this.isWinner(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return this.isWinner(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        boolean result = false;
        for (var cellX = 0; cellX < 3; cellX++) {
            for (var cellY = 0; cellY < 3; cellY++) {
                if ((!this.table[cellX][cellY].hasMarkX())
                    && (!this.table[cellX][cellY].hasMarkO())) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
