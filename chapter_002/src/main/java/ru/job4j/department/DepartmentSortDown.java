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
        Comparator<String> rc = (aStr, bStr) -> {
            int min = Math.min(aStr.length(), bStr.length());
            for (int index = 0; index < min; index++) {
                Character leftChar = aStr.charAt(index);
                Character rightChar = bStr.charAt(index);
                if (rightChar.compareTo(leftChar) != 0) {
                    return rightChar - leftChar;
                }
            }
            return aStr.length() - bStr.length();
        };

        divSort = new TreeSet<>(rc);

        // добавим элементы соллекции ArrayList в TreeSet
        divSort.addAll(div);
//        System.out.println(">>>" + divSort);
        return divSort;
    }

    interface StrLength {
        int compare(String a, String b);
    }


    //неявно реализуем интерфейс
    public static ServiceFactory factory = new ServiceFactory() {
        public Service getService() {
            return new DepartmentSortDown();
        }
    };
}
