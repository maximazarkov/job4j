package ru.job4j.bank;

import java.util.Objects;

/**
 * @author Azarkov Maxim.
 * @version 1.0 07.10.2021
 */
public class User {
    private String username;
    private String passport;

    public User(String passport, String username) {
        this.username = username;
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, passport);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }

//    @Override
//    public int compareTo(User user) {
//        return this.passport.compareTo(user.passport);
//    }
}