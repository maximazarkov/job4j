package ru.job4j.lambda;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class GroupTest {

    @Test
    public void whenCreateStudents() {
        Set<String> unit = new HashSet<>();
        unit.add("Geography");
        unit.add("Math");
        Student st = new Student("Student name", unit);

        String expected = "Student name";
        assertThat(st.getName(), is(expected));
        assertThat(st.getUnits(), is(unit));
    }

    @Test
    public void whenGroupStudents() {
        Map<String, Set<Student>> expected = new HashMap<>();
        expected.put("Student1 name", new HashSet<>());
        expected.put("Student2 name", new HashSet<>());
        expected.put("Student3 name", new HashSet<>());
        List<Student> students = new ArrayList<>();
        students.add(new Student("Student1 name", new HashSet<>()));
        students.add(new Student("Student2 name", new HashSet<>()));
        students.add(new Student("Student3 name", new HashSet<>()));
        assertThat(Group.sections(students), is(expected));
    }
}