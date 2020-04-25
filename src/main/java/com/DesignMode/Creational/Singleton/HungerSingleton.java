package com.DesignMode.Creational.Singleton;

public class HungerSingleton {
    private static HungerSingleton hungerSingleton = new HungerSingleton();

    public HungerSingleton(){
    }

    public static HungerSingleton getInstance(){
        return hungerSingleton;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i=0;i<10;i++){
                System.out.println(new HungerSingleton());
            }
        }).start();
    }
}
