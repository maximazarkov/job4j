package ru.job4j.department;

public class Department {
     private static String[] divisions =  {
            "K1\\SK1", 
            "K1\\SK2", 
            "K1\\SK1\\SSK1",
            "K1\\SK1\\SSK2",
            "K2",
            "K2\\SK1\\SSK1",
            "K2\\SK1\\SSK2"
    };

    public static void sorting(ServiceFactory fact) {
        Service s = fact.getService();
        s.sortDivisions(divisions);
    }
    public static void main(String[] args) {
        //sorting(DepartmentSort.factory);
        sorting(DepartmentSortUp.factory);
        sorting(DepartmentSortDown.factory);

    }
}
