package com.Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldDemo {

    public void fieldInfo() throws NoSuchFieldException {
        Class student = Student.class;

        Field score = student.getDeclaredField("score");    //获取Field实例
        System.out.println(score.getName());
        System.out.println(score.getType());
        int m = score.getModifiers();
        System.out.println(Modifier.isNative(m));
        System.out.println(Modifier.isPublic(m));
        System.out.println(Modifier.isFinal(m));
        System.out.println(Modifier.isPrivate(m));
    }

    public void fieldValue() throws NoSuchFieldException, IllegalAccessException {
        Person student = new Student(5);
        Class c = student.getClass();
        Field s = c.getDeclaredField("score");
        if(!s.isAccessible()){  // 判断该字段是否允许访问
            s.setAccessible(true);  // 如果该字段为private，则调用这个方法
        }
        // 获取字段的值
        System.out.println(s.get(student));

        // 设置字段的值
        s.set(student,10);
        System.out.println(s.get(student));
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        FieldDemo fieldDemo = new FieldDemo();
        // 根据Class实例获取字段信息
        fieldDemo.fieldInfo();
        // 根据Field实例获取字段的值
        fieldDemo.fieldValue();

    }
}

class Person {
    public String name;
}

class Student extends Person {
    private int score;

    Student(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }
}