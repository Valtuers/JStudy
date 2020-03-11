package com.Reflect;

public class ClassDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //1 获取Class实例的三个方法
        //1.1 获取类的Class实例
        Class cls1 = String.class;
        //1.2 获取变量的Class实例
        String a = "1";
        Class cls2 = a.getClass();
        //1.3 通过类名获取Class实例
        Class cls3 = Class.forName("java.lang.String");

        //2 Class实例的比较
        //2.1 不同方法获取的实例是相同的
        boolean sameClass = cls1 == cls2;
        System.out.println(sameClass);
        //2.2 使用instanceOf和==比较的区别
        Integer i = new Integer(123);
        System.out.println(new Integer(123) instanceof Number); //instanceOf可匹配子类
        System.out.println(i.getClass() == Integer.class);  // == 可精确判断数据类型，不能作子类比较

        //3 可使用Class实例进行的操作
        classInfo(String[].class);

        //4 可使用Class实例创建新实例
        String s4 = String.class.newInstance();
    }

    public static void classInfo(Class cls){
        System.out.println("全类名："+cls.getName());
        if(cls.getPackage() != null){
            System.out.println("包名："+cls.getPackage().getName());
        }
        System.out.println("类名："+cls.getSimpleName());
        System.out.println("是否接口："+cls.isInterface());
        System.out.println("是否枚举："+cls.isEnum());
        System.out.println("是否数组："+cls.isArray());
        System.out.println("是否原始类："+cls.isPrimitive());
    }
}
