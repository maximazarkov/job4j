package ru.job4j;

import java.util.Objects;

public class Profile implements Comparable {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        return Objects.equals(address, profile.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    @Override
    public int compareTo(Object o) {
        Profile profile = (Profile) o;
        return this.address.compareTo(profile.getAddress());
    }
}
