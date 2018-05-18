package com.timebusker.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @DESC:${DESCRIPTION}
 * @author: timebusker
 * @date:2018/5/6
 */
public abstract class BaseDaoImpl<T> implements BaseDao {

    private Logger log = LoggerFactory.getLogger("BaseDaoImpl");

    @Override
    public Object get(int id) {
        log.info("传入参数：" + id);
        return null;
    }

    @Override
    public Object add(T o) {
        log.info("传入参数：" + id);
        return null;
    }

    @Override
    public Object delete(String id) {
        return null;
    }

    @Override
    public Object update(T o) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }
}
