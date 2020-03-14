package com.Generic;

public class GenericDemo<T,K> {
    private K name;
    private T age;

    public static GenericDemo getAll(){
        return new GenericDemo();
    }

    public K getName() {
        return name;
    }

    public void setName(K name) {
        this.name = name;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "GenericDemo{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        GenericDemo<Integer, String> genericDemo = new GenericDemo<>();
        genericDemo.setAge(12);
        genericDemo.setName("哈哈哈");
        System.out.println(genericDemo.toString());

    }
}
