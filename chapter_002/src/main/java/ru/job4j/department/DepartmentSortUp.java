package ru.job4j.department;

class DepartmentSortUp extends DepartmentSort implements Service {
    private DepartmentSortUp() {}

    /**
     *
     * @param divisions
     */
    @Override
    public void sortDivisions(String[] divisions) {

        System.out.println("-------------------------");
        System.out.println("Сортировка по возрастанию");
        for (String item : parsedertment(divisions)) {
            System.out.println(item);
        }
    }

    //неявно реализуем интерфейс
    public static ServiceFactory factory = new ServiceFactory() {
        public Service getService() {
            return new DepartmentSortUp();
        }
    };
}
