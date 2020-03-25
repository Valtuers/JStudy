package com.DesignMode.Creational.Singleton;

public class HungrySingleton {
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    public HungrySingleton(){
    }

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
