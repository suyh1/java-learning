package com.suyh.bean;

public abstract class Person {
    private String id;
    private String name;
    private String birthday;
    private int age;
    private char sex;

    public Person(String id, String name, String birthday, int age, char sex) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.age = age;
        this.sex = sex;
    }

    public abstract String description();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
