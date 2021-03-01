package com.adomas.service.list;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListService<T> {

    List<T> list = new ArrayList<>();

    public List<T> findAll() {
        return new ArrayList<>(list);
    }

    public T save(T object) {
        if (object != null) {
            list.add(object);
        } else {
            throw new RuntimeException("Illegal object");
        }
        return object;
    }

    public void delete(T object) {

    }

    void addContact(T contact) {

    }
}
