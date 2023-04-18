package com.suyh.work;

public class Manager extends Abworker{

    private int num;

    public Manager() {
        super(); // 自动添加，可以不写
    }

    public Manager(String id, String name, double salary, int num) {
        super(id, name, salary);
        this.num = num;
    }

    @Override
    public void work() {
        System.out.println("工作");
    }

    public String toString() {
        return "Manager{}";
    }
}
