package ru.job4j.department;

import java.util.ArrayList;
import java.util.TreeSet;

public interface Service {
    /**
     * Сортирует коллекицию ArrayList типа String.
     * @author Азарков Максим
     * @param divisions
     * @since 0.6
     * @deprecated. поддержка с версии 0.7 прекращена
     */
    void sortDivisions(ArrayList<String> divisions);

    /**
     * Сортирует коллкцию TreeSet типа String
     * @author Азарков Максим
     * @param divisions
     * @since 0.6
     * @deprecated. поддержка с версии 0.7 прекращена
     */
    void sortDivisions(TreeSet<String> divisions);

    /**
     * сортирует введенный массив (коллекцию) ArrayList
     * @param divisions1 - входящая коллекция
     * @param divisionsSorting - ссылка на внешний отсортированный список
     * @return - отсортированные список в контейнере TreeSet
     */
    TreeSet<String> sortDivisions(ArrayList<String> divisions1, TreeSet<String> divisionsSorting);
}
