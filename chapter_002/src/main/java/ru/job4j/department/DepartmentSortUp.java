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
     * @deprecated
     */
    public void sortDivisions(ArrayList<String> divisions) {
        Collections.sort(divisions);
    }

    /**
     * @deprecated
     * @param divisions
     */
    public void sortDivisions(TreeSet<String> divisions) {

    }

    /**
     * сортирует введенный массив (коллекцию) ArrayList
     * @param div - входящая коллекция
     * @param divSort - ссылка на внешний отсортированный список
     * @return - отсортированные список в контейнере TreeSet
     */
    public TreeSet<String> sortDivisions(ArrayList<String> div, TreeSet<String> divSort) {
        divSort = new TreeSet<String>();
        divSort.addAll(div);
//        System.out.println(">>>" + divSort);
        return divSort;
    }


    //неявно реализуем интерфейс
    public static ServiceFactory factory = new ServiceFactory() {
        public Service getService() {
            return new DepartmentSortUp();
        }
    };
}
