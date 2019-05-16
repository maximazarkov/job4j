package ru.job4j.department;

class DepartmentSortDown extends DepartmentSort implements Service {
    private DepartmentSortDown() {}

    @Override
    public void sortDivisions(String[] divisions) {
        System.out.println("-------------------------");
        System.out.println("Сортировка по убыванию");
        createTempl();
//        printTempl();

    }

    //неявно реализуем интерфейс
    public static ServiceFactory factory = new ServiceFactory() {
        public Service getService() {
            return new DepartmentSortDown();
        }
    };
}
