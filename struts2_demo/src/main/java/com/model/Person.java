package com.model;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;

/**
 * @author peigen
 */
public class Person {
    private String name;
    private int sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
