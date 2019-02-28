package ru.job4j.array;

public class BubbleSort {
    // пока вынесу все переменные за методы. при необходимости, методы можно перенести и изменить конструктор
    //или можно добавить ещепеременных, которые в зависимости от перегруженного конструктора будут активироваться
    //{1, 5, 4, 2, 3, 1, 7, 8, 0, 5}
    private int[] array;
    private int currentLenght;

    public BubbleSort(int[] array) {
        this.array = array;
        this.currentLenght = array.length - 1;
    }

    public int[] bubbleSortIntArray() {
        int tmp;
        while (currentLenght > 0) {
            for (int i = 0; i < currentLenght; i++) {
                for (int j = 0; j <= i; j++) {
                    if (array[i] > array[i + 1]) {
                        tmp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = tmp;
                    }

                }
            }
            currentLenght--;
        }
        return array;
    }
}
