package com.suyh.bean;

public class Teacher extends Person {
    public Teacher(String id, String name, String birthday, int age, char sex) {
        super(id, name, birthday, age, sex);
    }

    @Override
    public String description() {
        return "我是一名老师，我的工作是教学";
    }
}
