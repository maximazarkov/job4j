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

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SchoolTest {

    @Test
    public void whenScoreGreaterOrEqual70() {
        School school = new School();
        List<Student> students = students();
        List<Student> class10A = school.collect(students, student -> student.getScope() >= 70);
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
        List<Student> class10B = school.collect(students, student -> (student.getScope() >= 50) && (student.getScope() < 70));
        Collections.sort(class10B);
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
        List<Student> class10C = school.collect(students, student -> student.getScope() < 50);
        List<Student> expected = List.of(
                new Student("Sturdent6", 45),
                new Student("Sturdent7", 40)
        );
        assertThat(class10C, is(expected));
    }

    @Test
    public void whenListToMap() {
        School school = new School();
        List<Student> students = students();
        Map<String, Student> classMap = school.collect(students,
                student -> student.getNameStudent(),
                student -> student);
        Map<String, Student> expected = Map.of(
                "Sturdent1", new Student("Sturdent1", 95),
                "Sturdent2", new Student("Sturdent2", 75),
                "Sturdent3", new Student("Sturdent3", 70),
                "Sturdent4", new Student("Sturdent4", 65),
                "Sturdent5", new Student("Sturdent5", 50),
                "Sturdent6", new Student("Sturdent6", 45),
                "Sturdent7", new Student("Sturdent7", 40)
        );
        assertThat(classMap, is(expected));
    }

    @Test
    public void whenBound70() {
        School school = new School();
        List<Student> students = students();
        List<Student> class10A = school.levelOf(students, 70);

        List<Student> expected = List.of(
                new Student("Sturdent1", 95),
                new Student("Sturdent2", 75),
                new Student("Sturdent3", 70)
        );
        assertThat(class10A, is(expected));

    }

    private List<Student> students() {
        return List.of(
                new Student("Sturdent1", 95),
                new Student("Sturdent2", 75),
                new Student("Sturdent5", 50),
                new Student("Sturdent3", 70),
                new Student("Sturdent6", 45),
                new Student("Sturdent4", 65),
                new Student("Sturdent7", 40)
        );
    }
}