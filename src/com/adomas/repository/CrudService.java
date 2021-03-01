package com.adomas.repository;

import java.util.List;

public interface CrudService<T> {

    List<T> findAll();

    T save(T object);

    void delete(T object);

}
