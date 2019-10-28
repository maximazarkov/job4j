package ru.job4j;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public Matrix() {
    }

//    не рабочий вариант
//    public List<Integer> collect(Integer[][] matrix, Predicate<Integer> predicate) {
//    вариант с List
//    public List<Integer> collect(List<List<Integer>> matrix) {
//    вариант для Stream.of()...
    public List<Integer> collect(Stream<List<Integer>> matrix) {
        return matrix
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
