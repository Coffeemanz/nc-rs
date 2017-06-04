package com.zhyshkevich.dao.interfaces;

import java.util.List;

/**
 * Created by Сергей on 30.05.2017.
 */
public interface BaseDao<T> {

    int save(T entity);

    List<T> getAll();

    T getById(int id);

    void update(T entity);

    void delete(int id);
}
