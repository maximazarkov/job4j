package ru.job4j.department;

import java.io.*;
import java.util.*;

/**
 * Программа Department сортировки департаментов создана в учебных целях, в качестве экзаменационной работы по ООП.
 * В данную работу для тренировки были включены API по работе с файлом, а так же с Collection framework.
 * задача решена с помощью применения паттерна Фабрика
 * Так же в задаче применены внутренние классы в целях закрепления материала
 *
 * @author Азарков Максим
 */
public class Department {

    private static ArrayList<String> divisions1 = new ArrayList<String>();
    private static TreeSet<String> divisionsSorting;

    private void getDivisions(){
        try {
            //по какой-то причине просто указанное имя файла вызвало Exception - file not found.
            //временно добавлен полный путь к файлу
            String pathFile="c:\\projects\\job4j\\chapter_002\\src\\main\\java\\ru\\job4j\\department\\";
            File file = new File(pathFile + "departmentList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addDivision(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addDivision(String lineToParse) {
        String[] tokens = lineToParse.split("\\\\");
        String subTokens = tokens[0];
        for(int index=1; index < tokens.length; index++){
            if(index % 2 == 0) {
                subTokens += "\\" + tokens[index];
            }
            divisions1.add(subTokens);
        }
    }

    /**
     * Сортирует коллекцию ArrayList и TreeSet
     * @param fact - "метод" фабрики, одна изреализаций
     */
    public static void sorting(ServiceFactory fact) {
        Service s = fact.getService();
        divisionsSorting = s.sortDivisions(divisions1, divisionsSorting);
    }

    private void printDivision() {
        System.out.print("ArrayList: ");
        System.out.println(divisions1);
        System.out.print("TreeSat: ");
        System.out.println(divisionsSorting);
        System.out.println();

    }

    private void go() {
        getDivisions();
        System.out.println("-- Загруженные данные --");
        printDivision();

        System.out.println("-- Сортировка по возрастанию --");
        sorting(DepartmentSortUp.factory);
        printDivision();

        System.out.println("-- Сортировка по убыванию --");
        sorting(DepartmentSortDown.factory);
        printDivision();
    }

    public static void main(String[] args) {
        new Department().go();
    }
}
