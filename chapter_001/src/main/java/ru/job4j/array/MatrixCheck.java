package ru.job4j.array;

/**
 * MatrixCheck.
 * @author Azarkov Maxim.
 * @version $Id$.
 * @since 0.1.
 */
public class MatrixCheck {

    /**
     * mono - проверка совпадения true или false по диагоналям матрицы.
     * @param data - матрица.
     * @return - true - совпадает, false - не совпадает.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int h; //динамический ширина/высота с конца матрицы. введены для наглядности
        for (int i = 0; i < data.length - 1; i++) {
            h = data[i].length - i - 1;    // введем переменную, чтоб дебаг удобнее было выполнить
            if ((data[i][i] != data[i + 1][i + 1]) || (data[i][h] != data[i + 1][h - 1])) {
                result = false;
                break;
            }
        }
        return result;
    }
}