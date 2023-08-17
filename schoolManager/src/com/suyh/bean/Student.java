package com.suyh.bean;

public class Student extends Person {
    public Student(String id, String name, String birthday, int age, char sex) {
        super(id, name, birthday, age, sex);
    }

    @Override
    public String description() {
        return "我是一名学生，我的工作是学习";
    }
}
