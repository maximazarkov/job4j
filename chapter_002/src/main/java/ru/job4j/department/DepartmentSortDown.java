package ru.job4j.department;

import java.util.*;

class DepartmentSortDown implements Service {
    private DepartmentSortDown() {}

    /**
     * @deprecated
     * @param divisions
     */
    public void sortDivisions(ArrayList<String> divisions) {
        Collections.sort(divisions, Collections.reverseOrder());}

    /**
     * @deprecated
     * @param divisions
     */
    public void sortDivisions(TreeSet<String> divisions) {
//        TreeSet<String> ts = new TreeSet<String>(new CompRevers());
//        ts = divisions;
//        divisions = ts;
    }

    public TreeSet<String> sortDivisions(ArrayList<String> div, TreeSet<String> divSort) {
        // отсортируем собственным компаратором в обратном направлении
//        CompRevers cr = new CompRevers();
//        divSort = new TreeSet<>(cr);

        // Воспользуемся встроенным методом обратной сортироки
//        CompNormal cn = new CompNormal();
//        divSort = new TreeSet<>(cn.reversed());

        // Воспльзуемся лямбда выражением
        Comparator<String> rc = (aStr, bStr) -> bStr.compareTo(aStr);
        divSort = new TreeSet<>(rc);

        // добавим элементы соллекции ArrayList в TreeSet
        divSort.addAll(div);
//        System.out.println(">>>" + divSort);
        return divSort;
    }


    //неявно реализуем интерфейс
    public static ServiceFactory factory = new ServiceFactory() {
        public Service getService() {
            return new DepartmentSortDown();
        }
    };
}
