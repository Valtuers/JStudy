package com.Reflect;

public class InheritDemo {

    public void inheritInfo(){
        // 获取Class实例的父类信息
        Class i = Integer.class;
        System.out.println(i.getSuperclass().getName());
        System.out.println(i.getSuperclass().getSuperclass().getName());

        // 获取Class实例的接口信息
        Class[] interfaces = i.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c.getName());
            //获取接口的父类
            System.out.println(c.getInterfaces());
        }

        // 判断两个Class实例向上转型是否成立
        // Integer i = ?
        Integer.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Integer
        // Number n = ?
        Number.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Number
        // Object o = ?
        Object.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Object
        // Integer i = ?
        Integer.class.isAssignableFrom(Number.class); // false，因为Number不能赋值给Integer
    }


    public static void main(String[] args) {
        InheritDemo inheritDemo = new InheritDemo();
        inheritDemo.inheritInfo();
    }
}
