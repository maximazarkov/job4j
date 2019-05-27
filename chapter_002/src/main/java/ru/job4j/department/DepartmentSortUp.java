package ru.job4j.department;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Collections;

class DepartmentSortUp implements Service {
    private DepartmentSortUp() {}

    /**
     * Сортирует соллекцию ArrayList типа String.
     * @author Азарков Максим
     * @param divisions - коллекция ArrayList типа String
     */
    public void sortDivisions(ArrayList<String> divisions) {
        Collections.sort(divisions);
    }

    public void sortDivisions(TreeSet<String> divisions) {}

    //неявно реализуем интерфейс
    public static ServiceFactory factory = new ServiceFactory() {
        public Service getService() {
            return new DepartmentSortUp();
        }
    };
}
