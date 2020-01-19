package ru.job4j.generic;

/**
 * @author Azarkov Maxim
 * @version $Id$
 * @since 0.1
 */
public class RoleStore extends SimpleArray implements Store<Role> {
    public RoleStore(int size) {
        super(size);
    }

    @Override
    public void add(Role model) {

    }

    @Override
    public boolean replace(String id, Role model) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Role findById(String id) {
        return null;
    }
}
