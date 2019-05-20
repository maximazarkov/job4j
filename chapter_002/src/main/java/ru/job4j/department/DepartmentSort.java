package ru.job4j.department;

public abstract class  DepartmentSort implements Service {
    String[][] templ = new String[2][3];

    public abstract void sortDivisions(String[] divisions);


    private boolean checkDubleBrunch(String[][] tree, String sndStr, int countBrunch) {
        for (int brunch = 0; brunch < countBrunch; brunch++) {
            fstStr = tree[brunch][level];
        }
    }

    private boolean addBrunch(String[][] tree, String[] resultBrunch, int level, int countBrunch) {
        boolean result = false;
        String fstStr;
        String sndStr;

        if ((level + 1 >= resultBrunch.length) ||
                (resultBrunch[level + 1] != null) ||
                (tree[countBrunch][level + 1] == null)) {
            fstStr = tree[countBrunch-1][level];
            sndStr = resultBrunch[level];
        } else {
            fstStr = tree[countBrunch][level] + "\\" + tree[countBrunch][level + 1];
            sndStr = resultBrunch[level]+ "\\" + resultBrunch[level + 1];
        }

        if(fstStr.equals(sndStr)) {
                result = true;
        }
        return result;
    }


    /**
     *
     * @param divisions - массив департаментов и отделов
     * @return - массив, расширенный список департаментов
     */
    String[][] parseDepartment(String[] divisions) {
        String[] resultBrunch = new String[4];  // зададим ширину дерева жестко, без проверки
        String[][] resultTree = new String[20][resultBrunch.length]; // высота "дерева"

        //распасим каждую строку, чтобы дополнить новый массив скрытыми отделами или департаментам
        int countBrunch = 0;
        for(String div : divisions) {
            resultBrunch = div.split("\\\\");
            for(int index = 0; index < resultBrunch.length; index++) {

                // если попалась первая стройка, то просто запишем первый эелемент в отдельную ветку
                //и перейдем ко второму элементу строки
                if(countBrunch == 0) {
                    resultTree[countBrunch++][index] = resultBrunch[index];
                    continue;
                }

                // если вылезли за край ветки, то просто вносим последний элемент и переходим
                // к слудующей строке
                if((index + 1 >= resultBrunch.length)) {
                    System.out.println(addBrunch(resultTree, resultBrunch, index, countBrunch));
                    resultTree[countBrunch++][index] = resultBrunch[index];
                    continue;
                }
                if(resultBrunch[index] != null) {
                    resultTree[countBrunch][index] = resultBrunch[index];
                }
            }
            countBrunch++;
        }
        return resultTree;

    }

//    public String toString(){
    public void printDepartment(String[][] items){
        for (int i=0; i !=items.length; i++ ) {
            for(int j=0; j != items[i].length; j++){
                System.out.print(items[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param divisions - массив департаментов и отделов
     * @return - массив, расширенный список департаментов
     */
    String[] parsedepartment(String[] divisions) {
        String[] resultTmp = new String[20];    // первиный размер выходного массива
        int resultCount = 0;                    // счетчик элементов нового массива

        //распасим каждую строку, чтобы дополнить новый массив скрытыми отделами или департаментами
        for(String div : divisions) {
            String[] tmp = div.split("\\\\");
            // проверяем кажый департамент, подразделение и отдел на повторение
            for (int j=0; j < tmp.length; j++) {
                boolean addItem = true;     // по умочанию чситаем, что элемент новый

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
        for (String[] sTemp : templ) {
            for (String s : sTemp) {
                System.out.println(s);
            }
        }
    }

    /**
     * заполним массив возмнжными кодами подразделений
     */
    void createTempl() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                templ[j][i] = getCharS(i) + 'K' + ( j + 1 );
            }
        }
        //return "";
    }

    /**
     * процедура, возвращающая строку, состоящую из знаков "S" в количe
     * стве, указанном в переменной n.
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
