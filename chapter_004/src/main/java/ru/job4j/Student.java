package ru.job4j;

import java.util.Objects;

public class Student {
    private String nameStudent;
    private int score;

    public String getNameStudent() {
        return nameStudent;
    }

    /**
     * Класс содержит информацию о имени студента и его успеваемость в баллах
     * @param nameStudent - имя студента
     * @param score - успеваемость
     * @since v0.2 16.10.2019
     */
    public Student(String nameStudent, int score) {
        this.nameStudent = nameStudent;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{"
                + "nameStudent='" + nameStudent + '\''
                + ", score=" + score
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
        return score == student.score
                && Objects.equals(nameStudent, student.nameStudent);
    }

    /**
     * переопределяется по умолчанию совместно с equals()
     * @return - возвращает hash для класса Student
     * @since v0.3 17.10.2019
     */
    @Override
    public int hashCode() {
        return Objects.hash(nameStudent, score);
    }
}