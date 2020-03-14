package com.Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ListDemo {
    /*
      比较ArrayList和LinkedList
      获取指定元素： 1、速度很快，2、需要从头开始查找元素
      添加元素到末尾： 1、速度很快，2、速度很快
      在指定位置添加/删除： 1、需要移动元素，2、不需要移动元素
      内存占用： 1、少，2、较大
     */

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
