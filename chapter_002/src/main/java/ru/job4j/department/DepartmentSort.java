package ru.job4j.department;

public abstract class  DepartmentSort implements Service {
    String[][] templ = new String[2][3];

    public abstract void sortDivisions(String[] divisions);

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
            for(int indexBrunch = 0; indexBrunch < resultBrunch.length; indexBrunch++) {

                // если попалась первая стройка, то не зависимо от количества элементов в строке
                // просто запишем первый эелемент в отдельную ветку и перейдем ко второму
                // элементу строки для записи его в следующую ветку
                if(countBrunch == 0) {
                    resultTree[countBrunch++][0] = resultBrunch[0];
                    continue;
                }

                //если элементы в строке закончились, переходим к следующей строке
                if(resultBrunch[indexBrunch] == null) {
                    break;
                } else {
                    //формируем новую ветку
                    for(int index=0; index <= indexBrunch; index++) {
                        //System.out.println(equalsBrunch(resultTree, resultBrunch, index));
                        if(equalsBrunch(resultTree, resultBrunch, index)) {
                            addBrunch(resultTree[countBrunch], resultBrunch);
                            //resultTree[countBrunch][index] = resultBrunch[index];
                        }
                        continue;
                    }
                    countBrunch++;
                }
            }
        }
        return resultTree;
    }

    private void addBrunch(String[] tree, String[] brunch) {
        for(int index = 0; index < brunch.length; index++) {
            tree[index] = brunch[index];
        }
    }

    private boolean equalsBrunch(String[][] tree, String[] brunch, int countElement) {
        String fstStr;
        String sndStr = brunch[0];

        if (countElement > 0) {
            for (int index = 0; index < brunch.length - 1; index++) {
                sndStr +=  "\\" + brunch[index + 1];
            }
        }


        for (int countBrunch = 0; countBrunch < tree.length; countBrunch++) {
            if (tree[countBrunch][0] != null) {
                fstStr = tree[countBrunch][0];
                for (int index = 0; index < countElement; index++) {
                    fstStr += "\\" + tree[countBrunch][index + 1];
                }
                if(fstStr.equals(sndStr)) {
                    return true;
                }
            }
        }
        return false;
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
