package com.DesignMode.Construction.Adapter;

public class InterfaceAdapter {
    public static void main(String[] args) {
        Dog dog = new Dog(new DogAdapter(){
            @Override
            public void eat() {
                System.out.println("狗吃东西啦！！！");
            }
        });
    }
}

interface Animal {
    void run();
    void eat();
    void sleep();
    void sit();
}

abstract class DogAdapter implements Animal {
    @Override
    public void run(){
    }
    @Override
    public void eat(){
    }
    @Override
    public void sleep(){
    }
    @Override
    public void sit(){
    }
}

class Dog {
    Dog(Animal animal){
        animal.run();
        animal.eat();
        animal.sleep();
        animal.sit();
    }
}
