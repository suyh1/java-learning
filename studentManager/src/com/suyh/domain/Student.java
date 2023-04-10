package com.suyh.domain;

public class Student {
    private String sid;
    private String name;
    private int age;
    private String addr;


    public Student() {
    }

    public Student(String sid, String name, int age, String addr) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    /**
     * 获取
     *
     * @return sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * 设置
     *
     * @param sid
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     *
     * @return addr
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置
     *
     * @param addr
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }
}
