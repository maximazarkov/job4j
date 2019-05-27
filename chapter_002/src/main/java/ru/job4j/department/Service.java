package ru.job4j.department;

import java.util.ArrayList;
import java.util.TreeSet;

public interface Service {
    /**
     * Сортирует коллекицию ArrayList типа String.
     * @author Азарков Максим
     * @param divisions
     * @since 0.6
     */
    void sortDivisions(ArrayList<String> divisions);

    /**
     * Сортирует коллкцию TreeSet типа String
     * @author Азарков Максим
     * @param divisions
     * @since 0.6
     */
    void sortDivisions(TreeSet<String> divisions);
}
