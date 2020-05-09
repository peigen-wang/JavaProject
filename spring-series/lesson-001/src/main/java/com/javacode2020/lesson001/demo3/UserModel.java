package com.javacode2020.lesson001.demo3;

public class UserModel {
    private String name;
    private int age;

    public UserModel() {
        this.name = "我是通过UserModel的无参构造方法创建的!";
    }

    public UserModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
