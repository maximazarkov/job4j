package ru.job4j;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class MatrixTest {

    @Test
    public void whenMatrixThenList() {
        Matrix matrix = new Matrix();
//        Чистый Integer[][] в стрим просто так не введешь
//        Integer[][] matrixInteger = {{1, 2}, {3, 4}};
//        Протестировал с List, успешно
//        List<List<Integer>> matrixInteger = List.of(
//                List.of(1, 2),
//                List.of(3, 4)
//        );
//      Теперь переведем все в Stream.of()...
        Stream<List<Integer>> matrixStream = Stream.of(List.of(1, 2), List.of(3, 4));
        List<Integer> result = matrix.collect(matrixStream);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(result, is(expected));
    }
}
