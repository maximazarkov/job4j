package ru.job4j;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .sorted()
                .distinct()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }
}
