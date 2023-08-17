package com.suyh.utils;

import com.suyh.bean.Person;
import com.suyh.bean.Student;

import java.util.ArrayList;

public class Util {
    public static int sid = 0;
    public static int tid = 0;

    /**
     * 用于打印所有的单个对象
     * @param p 接收要打印的对象
     */
    public static void showPerson(Person p) {
        System.out.println("**************************");
        System.out.println("编号\t姓名\t性别\t生日\t\t\t年龄\t描述");
        System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getSex()+"\t"+p.getBirthday()+"\t\t\t"+p.getAge()+"\t"+p.description());
        System.out.println("**************************");
    }

    /**
     * 用于打印所有的学生对象信息
     * @param array 接收存储所有学生对象的集合
     */
    public static void showAllStudent(ArrayList<Student> array) {
        System.out.println("**************************");
        System.out.println("编号\t姓名\t性别\t生日\t\t\t年龄\t描述");
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getSex()+"\t"+s.getBirthday()+"\t\t\t"+s.getAge()+"\t"+s.description());
        }
        System.out.println("**************************");
    }
}
