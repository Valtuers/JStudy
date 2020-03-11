package com.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo {

    public void getMethod() throws NoSuchMethodException {
        Class b = Boy.class;
        // 获取public的方法，参数为String数据类型
        System.out.println(b.getMethod("getScore", String.class));
        // 获取public的父方法，无参
        System.out.println(b.getMethod("getName"));
        // 获取private的方法，参数为int数据类型
        System.out.println(b.getDeclaredMethod("getGrade", int.class));

        Method gs = b.getMethod("getScore", String.class);
        System.out.println(gs.getName());
        System.out.println(gs.getReturnType());
        System.out.println(gs.getParameterTypes());
        System.out.println(gs.getModifiers());
    }

    public void invokeMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Man m = new Boy();
        Class b = Boy.class;
        Method getScore = b.getMethod("getScore", String.class);
        int res = (int) getScore.invoke(m,"");
        System.out.println(res);

        // 调用静态方法
        Method getToy = b.getMethod("getToy");
        String toy = (String) getToy.invoke(null);
        System.out.println(toy);

        // 调用非public方法
        Method getGrade = b.getDeclaredMethod("getGrade", int.class);
        getGrade.setAccessible(true);
        int grade = (int) getGrade.invoke(m, 2019);
        System.out.println(grade);

        // 多态
        Class man = Man.class;
        Method hello = man.getMethod("hello");
        hello.invoke(new Boy());
        hello.invoke(new Man());
    }

    public void constructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 调用无参构造方法
        Integer integer1 = Integer.class.newInstance();
        // 调用有参构造方法
        Constructor<Integer> cons1 = Integer.class.getConstructor(int.class);
        Integer integer2 = cons1.newInstance(123);
        System.out.println(integer2);
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        MethodDemo methodDemo = new MethodDemo();

        // 获取method实例
        methodDemo.getMethod();
        // 调用method实例
        methodDemo.invokeMethod();
        // 调用有参构造方法
        methodDemo.constructor();
    }
}

class Boy extends Man {
    public int getScore(String type) {
        return 99;
    }
    private int getGrade(int year) {
        return 1;
    }

    public void hello(){
        System.out.println("Student said:Hello!");
    }
}

class Man {
    public String getName() {
        return "Man";
    }

    public static String getToy(){
        return "car";
    }

    public void hello(){
        System.out.println("Man said:Hello!");
    }
}
