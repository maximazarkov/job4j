package ru.job4j.generic;

import java.util.Iterator;
import java.util.spi.AbstractResourceBundleProvider;

/**
 * @author Azarkov Maxim
 * @version $Id$
 * @since 0.1
 */
public class UserStore implements Store<User> {
//public class UserStore extends SimpleArray<String> implements Store<User> {
// столкнулся с проблемой получения типа User в методе findId(). Метод по непонятной причине возвращает String.
// Считаю, сто проблема связанна с с наследованием.
// попробую создать объект SimpleArray<> внутри класса UserStore
    private SimpleArray<User> us;
    private int size;

    public UserStore(int size) {
//        super(size);  //надобность отпала, но пока сохраню
        this.us = new SimpleArray<>(size);
        this.size = size;
    }

    @Override
    public void add(User model) {
//        this.add(model.getId());
        this.us.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        boolean result = false;

        int fibi = findIndexById(id);
        if (fibi != -1) {
            this.us.set(fibi, model);
            result = true;
        }

        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;

        int fibi = findIndexById(id);
        if (fibi != -1) {
            this.us.remove(fibi);
            result = true;
        }

        return result;
    }

    @Override
    public User findById(String id) {
        User result = null;

        for (User u : this.us) {
            if (u == null) {
                break;
            }
            if (u.getId().equals(id)) {
                result = u;
                break;
            }
        }
        return result;
    }

    private int findIndexById(String id) {
        int result = -1;

        int index = 0;
        for (User u : this.us) {
            if (u == null) {
                break;
            }
            if (u.getId().equals(id)) {
                result = index;
                break;
            }
            index++;
        }

        return result;
    }
}

