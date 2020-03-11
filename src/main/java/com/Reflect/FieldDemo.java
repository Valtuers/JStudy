package com.Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldDemo {

    public void fieldInfo() throws NoSuchFieldException {
        Class student = Student.class;

        Field score = student.getField("score");    //获取Field实例
        System.out.println(score.getName());
        System.out.println(score.getType());
        int m = score.getModifiers();
        System.out.println(Modifier.isNative(m));
        System.out.println(Modifier.isPublic(m));
        System.out.println(Modifier.isFinal(m));
        System.out.println(Modifier.isPrivate(m));
    }

    public void fieldValue() throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student(5);
        Class c = student.getClass();
        Field s = c.getDeclaredField("score");
        s.setAccessible(true);  // 如果该字段为private，则调用这个方法
        Object value = s.get(student);
        System.out.println(value);
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
}