package ru.job4j.lambda;

import java.util.List;
import java.util.stream.Stream;

public class Count {
    public int count(List<Integer> data) {
//        Stream<Integer> st = data.stream();
//        int result = (int) st.count();
//        return result;
        return (int) data.stream()
            .count();
//        return data.size();
    }
}
