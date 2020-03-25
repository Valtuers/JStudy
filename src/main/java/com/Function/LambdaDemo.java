package com.Function;

import java.util.stream.Stream;

public class LambdaDemo {
    /*
        接口只有一个抽象方法的时候就可以用Lambda
     */
    public void functionalInterface(int s){
        Person.run(speed -> speed+s);
    }
    /*
        只要参数类型和返回类型一致，静态方法就可以作为lambda表达式传入
     */
    public void methodInterface(){
        Person.run(Person::go);
    }

    public static void main(String[] args) {
        LambdaDemo lambdaDemo = new LambdaDemo();
        lambdaDemo.functionalInterface(2);
        lambdaDemo.methodInterface();

        Stream.of(1,2,3,4).forEach(System.out::println);
    }
}

class Person{
    static void run(Animal animal){
        int i = animal.walk(1);
        animal.eat();
        System.out.println(i);
    }

    static int go(int speed){
        return speed+1;
    }
}

@FunctionalInterface
interface Animal{
    int walk(int speed);

    default void eat(){
        System.out.println("吃吃吃！！！");
    }
}
