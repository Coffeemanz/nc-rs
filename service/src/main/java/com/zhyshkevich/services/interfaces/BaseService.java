package com.zhyshkevich.services.interfaces;

import com.zhyshkevich.services.dto.BasicDto;

import java.util.List;

/**
 * Created by Сергей on 31.05.2017.
 */
public interface BaseService <T extends BasicDto> {

    int save(T entity);

    void delete(int id);

    void update(T entity);

    List<T> getAll();

    T get(int id);
}
