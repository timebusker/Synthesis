package com.timebusker.dao;

import java.util.List;

/**
 * @DESC:${DESCRIPTION}
 * @author: timebusker
 * @date:2018/5/6
 */
public interface BaseDao<T> {

    public T get(int id);

    public T add(T t);

    public T delete(String id);

    public T update(T t);

    public List<T> getAll();
}
