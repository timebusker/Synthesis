package com.timebusker.model;

import java.io.Serializable;

/**
 * @DESC:${DESCRIPTION}
 * @author: timebusker
 * @date:2018/5/6
 */
public class UserInfoBean implements Serializable {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
