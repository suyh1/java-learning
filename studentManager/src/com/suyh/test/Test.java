package com.suyh.test;

import com.suyh.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        Scanner sc = new Scanner(System.in);
        Student defaultStu = new Student("stu001", "小明", 100, "北京");
        list.add(defaultStu);

        while (true) {
            System.out.println("------欢迎来到学生管理系统------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看学生");
            System.out.println("5 退出");
            System.out.println("请输入您的选择：");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(list);
                    break;
                case 2:
                    deleteStudent(list);
                    break;
                case 3:
                    setStudent(list);
                    break;
                case 4:
                    queryStudentInfo(list);
                    break;
                case 5:
                    System.out.println("感谢使用!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("您的输入不正确");
                    break;
            }

        }

    }

    /**
     * 修改学生信息
     */
    private static void setStudent(ArrayList<Student> list) {
        System.out.println("请输入待修改学生的学号");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int index = getIndex(list, id);
        Student stu = list.get(index);
        System.out.println("您要修改的学生信息为: " + stu);
        System.out.println("请输入待添加学生的姓名, 0为不修改");
        String name = sc.next();
        if (!"0".equals(name)) {
            stu.setName(name);
        }
        System.out.println("请输入待添加学生的年龄, 0为不修改");
        int age = sc.nextInt();
        if (age != 0) {
            stu.setAge(age);
        }
        System.out.println("请输入待添加学生的住址, 0为不修改");
        String addr = sc.next();
        if (!"0".equals(addr)) {
            stu.setAddr(addr);
        }
        list.set(index, stu);
        System.out.println("修改成功,修改后的信息为");
        System.out.println(stu.toString());
    }

    /**
     * 查看学生信息
     */
    private static void queryStudentInfo(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("!!!学生信息为空,请先添加数据!!!");
        } else {
            System.out.println("学号\t\t\t姓名\t\t年龄\t\t住址");
            for (int i = 0; i < list.size(); i++) {
                Student stu = list.get(i);
                System.out.println(stu.getSid() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getAddr());
            }
        }

    }

    /**
     * 删除学生信息
     */
    private static void deleteStudent(ArrayList<Student> list) {
        System.out.println("请输入要删除学生的学号:");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int index = getIndex(list, id);
        list.remove(index);
        System.out.println("删除学生信息成功!");
    }

    private static int getIndex(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSid().equals(id)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 添加学生信息
     */
    private static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入待添加学生的学号");
        String sid = sc.next();
        System.out.println("请输入待添加学生的姓名");
        String name = sc.next();
        System.out.println("请输入待添加学生的年龄");
        int age = sc.nextInt();
        System.out.println("请输入待添加学生的住址");
        String addr = sc.next();

        Student stu = new Student(sid, name, age, addr);
        list.add(stu);
        System.out.println(stu.toString() + "添加成功!");
    }


}
