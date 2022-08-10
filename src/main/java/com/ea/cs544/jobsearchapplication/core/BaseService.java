package com.ea.cs544.jobsearchapplication.core;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, I> {

    T save(T t);

    Optional<T> findOne(I i);

    List<T> findAll();

    void deleteById(I i);

}
