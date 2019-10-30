//В туристической компании появилась задача составить список адресов клиентов.
//В анкете у клиента, есть адрес проживания.
//Анкета клиента описывается моделью
//Задание.
//1. Создать класс Profiles и метод List<Address> collect(List<Profile> profiles);
//2. При решении задания нужно использовать Stream API, метод map, метод collect(Collections.toList());
//3. Метод Stream.map - принимает элемент потока и возвращает другой элемент.
package ru.job4j;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


public class ProfilesTest {
    @Test
    public void whenCreateAdtessList() {
        Profiles profiles = new Profiles();
        List<Profile> profileList = profiles();
        List<Address> addressList = profiles.collect(profileList);
        List<Address> expected = List.of(
                new Address("city1", "Street1", 5, 10),
                new Address("city2", "Street3", 34, 145),
                new Address("city3", "Street4", 867, 234)
        );
        assertThat(addressList, is(expected));

    }

    private List<Profile> profiles() {
        return List.of(
                new Profile(new Address("city2", "Street3", 34, 145)),
                new Profile(new Address("city1", "Street1", 5, 10)),
                new Profile(new Address("city2", "Street3", 34, 145)),
                new Profile(new Address("city2", "Street3", 34, 145)),
                new Profile(new Address("city3", "Street4", 867, 234))
        );
    }
}
