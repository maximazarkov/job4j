package ru.job4j.department;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

class DepartmentSortDown implements Service {
    private DepartmentSortDown() {}

    public void sortDivisions(ArrayList<String> divisions) {
        Collections.sort(divisions, Collections.reverseOrder());}

    public void sortDivisions(TreeSet<String> divisions) {
//        divisions.(divisions, Collections.reverseOrder());
    }


    //неявно реализуем интерфейс
    public static ServiceFactory factory = new ServiceFactory() {
        public Service getService() {
            return new DepartmentSortDown();
        }
    };
}
