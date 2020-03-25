package com.DesignMode.Creational.Prototype;

public class SimplePrototype {
    public static void main(String[] args) {
        Student s1 = new Student("林铭聪", 99);
        Student s2 = (Student) s1.clone();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
    }
}

class Student implements Cloneable {
    String name;
    int score;

    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
