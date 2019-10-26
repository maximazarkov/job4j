package ru.job4j;

import java.util.List;
import java.util.Objects;

public class Student implements Comparable {
    private String nameStudent;     //ФИО студента
    private int scope;              //Балл атестата

    /**
     * Класс содержит информацию о имени студента и его успеваемость в баллах
     * @param nameStudent - имя студента
     * @param scope - успеваемость
     * @since v0.2 16.10.2019
     */
    public Student(String nameStudent, int scope) {
        this.nameStudent = nameStudent;
        this.scope = scope;
    }

    public int getscope() {
        return scope;
    }

    @Override
    public String toString() {
        return "Student{"
                + "nameStudent='" + nameStudent + '\''
                + ", scope=" + scope
                + '}';
    }

    /**
     * Переопределим методы equals(). Создадим условие, для работы метода с слассом Student
     * Данный метод применяется в Тесте (в противном случае, даже при одинаковых классах - результатах) тесты падают
     * @param o - объект для обработки (по сути Student)
     * @return -  возвращаем результат сравнения объекта Student
     * @since v0.3 17.10.2019
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return scope == student.scope
                && Objects.equals(nameStudent, student.nameStudent);
    }

    /**
     * переопределяется по умолчанию совместно с equals()
     * @return - возвращает hash для класса Student
     * @since v0.3 17.10.2019
     */
    @Override
    public int hashCode() {
        return Objects.hash(nameStudent, scope);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}