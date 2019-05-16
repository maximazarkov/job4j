package ru.job4j.department;

public abstract class  DepartmentSort implements Service {
    String[] templ = new String[6];

    public abstract void sortDivisions(String[] divisions);

    /**
     * Вывод на печать талицы шаблонов
     */
    void printTempl(){
        for (String s : templ) {
            System.out.println(s);
        }
    }

    /**
     * заполним массив возмнжными кодами подразделений
     */
    void createTempl() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                templ[ 2 * i + j] = getCharS(i) + 'K' + ( j + 1 );
            }
        }
        //return "";
    }

    /**
     * процедура, возвращающая строку, состоящую из знаков "S" в количстве, указанном в переменной n.
     * @param n - количество знаков "S"
     */
    private String getCharS(int n) {
        //При желании можно прикрутить свистульку в виде StringBuffer или StringBuilder
        //но возпольуемся обычным String
        String result = "";
        while (n > 0) {
            result += 'S';
            n--;
        }
        return result;
    }

}
