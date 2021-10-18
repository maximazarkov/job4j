package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

public class PassportOfficeTest {
    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        Assert.assertEquals(citizen, office.get((citizen.getPassport())));
    }

    @Test
    public void whenAddDuplicateThenFalse() {
        PassportOffice office = new PassportOffice();
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Assert.assertTrue(office.add(citizen));
        Assert.assertFalse(office.add(citizen));
    }
}