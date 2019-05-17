package ru.job4j.department;

public abstract class  DepartmentSort implements Service {
    String[] templ = new String[6];

    public abstract void sortDivisions(String[] divisions);

    String[] parsedertment(String[] divisions) {
        String[] resultTmp = new String[20];
        int resultCount = 0;
        for(String div : divisions) {
            String[] tmp = div.split("\\\\");
            for (int j=0; j < tmp.length; j++) {
                boolean addItem = true;

                String res = tmp[0];
                if (j != 0 ) {

                    for(int k = 1; k <= j; k++) {
                        res += "\\" + tmp[k];
                    }
                }

                for(int i = 0; i < resultCount; i++) {
                    if (res.equals(resultTmp[i])) {
                        addItem = false;
                        break;
                    }
                }
                if(addItem) {
                    resultTmp[resultCount++] = res;
                }

            }
            //          System.out.println("-------------------------");
        }

//        System.out.println(resultCount);
        String[] result = new String[resultCount];
        System.arraycopy(resultTmp, 0, result, 0, resultCount);
        return result;
    }

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
