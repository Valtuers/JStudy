package com.Collection;

import com.google.common.collect.Lists;

import java.util.*;

public class ListDemo {
    /*
      比较1、ArrayList和2、LinkedList
      获取指定元素： 1、速度很快，2、需要从头开始查找元素
      添加元素到末尾： 1、速度很快，2、速度很快
      在指定位置添加/删除： 1、需要移动元素，2、不需要移动元素
      内存占用： 1、少，2、较大
     */
    public static void main(String[] args) {
        String[] arr = {"哈哈哈","啦啦啦","哦哦哦"};
        List<String> a = new ArrayList<>(Arrays.asList(arr));
        ArrayList<String> newArr = Lists.newArrayList(arr);
        Collections.reverse(newArr);
        newArr.add("噗噗噗");
        for(String s : newArr){
            System.out.println(s);
            if("哦哦哦".equals(s)){
                newArr.remove(s);
            }
        }
    }
}

class Person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


}
