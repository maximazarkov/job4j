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

import java.beans.BeanProperty;
import java.util.List;
import java.util.stream.Collectors;

public class SchoolTest {

    @Test
    public void whenScoreGreaterOrEqual70() {
        School school = new School();
        List<Student> students = students();
        List<Student> A10 = students.stream().filter(
                student -> student.getScore() > 70
        ).collect(Collectors.toList());
        A10.forEach(System.out::println);
        //school.collect(students, );
    }

    @Test
    public void whenScoreGreaterOrEqual50Less70() {
        School school = new School();
        List<Student> students = students();
        List<Student> B10 = students.stream().filter(
                student -> (student.getScore() > 50) && (student.getScore() < 70)
        ).collect(Collectors.toList());
        B10.forEach(System.out::println);
        //school.collect(students, );
    }

    @Test
    public void whenScoreLess50() {
        School school = new School();
        List<Student> students = students();
        List<Student> C10 = students.stream().filter(
                student -> student.getScore() < 50
        ).collect(Collectors.toList());
        C10.forEach(System.out::println);
        //school.collect(students, );
    }

    private List<Student> students() {
        return List.of(
                new Student(100),
                new Student(95),
                new Student(90),
                new Student(85),
                new Student(80),
                new Student(75),
                new Student(70),
                new Student(65),
                new Student(60),
                new Student(55),
                new Student(50),
                new Student(45),
                new Student(40)
        );
    }
}

//package ru.job4j;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class StreamUsage {
//
//    public static void main(String[] args) {
//        List<Task> bugs = tasks.stream().filter(// получаем объект типа Stream  и выполняе метод filter, который принимае лямбда выражение Predicate<Task>
//                task -> task.name.contains("Bug")   // задаем условие, что пропускать только те  задачи, которые содержат слово Bug.
//        ).collect(Collectors.toList());             // полученные результаты сохраняем в коллекции типа List.
//        bugs.forEach(System.out::println);
//
//        // Допустим, что на нужно получить только имена задач. Для этого нужно применить метод map.
//        List<String> names = tasks.stream().map(
//                task -> task.name
//        ).collect(Collectors.toList());
//        names.forEach(System.out::println);
//
//        // Давайте теперь посчитаем общую сумму потраченную на все задачи.
//        long total = tasks.stream().map(
//                task -> task.spent
//        ).reduce(0L, Long::sum);   //каждое значение task.spent - нужно сложить с начальным значение 0L.
//
//        System.out.println(total);
//    }
//}