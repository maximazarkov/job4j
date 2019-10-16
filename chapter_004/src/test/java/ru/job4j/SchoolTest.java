//В школе пришло требование разделить 9А класс на три класса.
//У каждого ученика есть общий балл по всем предметам.  int score;
//score - может быть в диапазоне от 0 до 100.
//Учеников нужно поделить на следующие группы.
//10А диапазон балла [70: 100],
//10Б диапазон балла [50: 70);
//10B диапазон балла (0: 50);
//Задание.
//1. Создайте класс Student. В классе Student должно быть одно поле int score;
//2. Создайте класс School c методом List<Student> collect(List<Student> students, Predicate<Student> predict);
//3. Создайте класс - тест SchoolTest с тремя методами для получения списка учеников для классов: А, B, C;
//4. В этом задании нужно использовать Stream API. метод filter и метод collect(Collectors.toList())
//import java.util.stream.Collectors;
package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

public class SchoolTest {

    @Test
    public void whenScoreGreaterOrEqual70() {
        School school = new School();
        List<Student> students = students();
        List<Student> class10A = school.collect(students, student -> student.getScore() >= 70);
        List<Student> expected = List.of(
                new Student("Sturdent1", 95),
                new Student("Sturdent2", 75),
                new Student("Sturdent3", 70)
        );
        assertThat(class10A, is(expected));
    }

    @Test
    public void whenScoreGreaterOrEqual50Less70() {
        School school = new School();
        List<Student> students = students();
        List<Student> class10B = school.collect(students, student -> (student.getScore() >= 50) && (student.getScore() < 70));
        List<Student> expected = List.of(
                new Student("Sturdent4", 65),
                new Student("Sturdent5", 50)
        );
        assertThat(class10B, is(expected));
    }

    @Test
    public void whenScoreLess50() {
        School school = new School();
        List<Student> students = students();
        List<Student> class10C = school.collect(students, student -> student.getScore() < 50);
        List<Student> expected = List.of(
                new Student("Sturdent1", 45),
                new Student("Sturdent1", 40)
        );
        assertThat(class10C, is(expected));
    }

    private List<Student> students() {
        return List.of(
                new Student("Sturdent1", 95),
                new Student("Sturdent2", 75),
                new Student("Sturdent3", 70),
                new Student("Sturdent4", 65),
                new Student("Sturdent5", 50),
                new Student("Sturdent1", 45),
                new Student("Sturdent1", 40)
        );
    }
}