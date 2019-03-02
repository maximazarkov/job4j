package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        //{"Привет", "Мир", "Привет", "Супер", "Мир"}
        //{"Привет", "Мир", "Супер"}
        ArrayDuplicate aDupl = new ArrayDuplicate();
        String[] expect = {"Привет", "Мир", "Супер"};
        String[] arr = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        arr = aDupl.remove(arr);
        assertThat(expect, is(arr));
    }
}