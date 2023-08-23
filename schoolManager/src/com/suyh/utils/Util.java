package com.suyh.utils;

import com.suyh.bean.Person;
import com.suyh.bean.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

    public static int birthdayToAge(String birthday) {
        int age = -1;
        Calendar birCal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birDate = null;
        try {
            birDate = sdf.parse(birthday);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        birCal.setTime(birDate);

        Calendar nowCal = Calendar.getInstance();
        if(birCal.before(nowCal)) {
            age = nowCal.get(Calendar.YEAR) - birCal.get(Calendar.YEAR);
            if((nowCal.get(Calendar.MONTH) < birCal.get(Calendar.MONTH)) || (nowCal.get(Calendar.MONTH) == birCal.get(Calendar.MONTH) &&
                    nowCal.get(Calendar.DAY_OF_MONTH) < birCal.get(Calendar.DAY_OF_MONTH))) {
                age--;
            }
        }
        return age;
    }
}
