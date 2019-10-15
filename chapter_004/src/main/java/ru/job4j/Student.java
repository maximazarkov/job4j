package ru.job4j;

public class Student {
    private String nameStudent;
    private int score;

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
}