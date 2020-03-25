package com.DesignMode.Creational.Singleton;

public class StaticSingleton {

    private static class Singleton{
        private static final StaticSingleton staticSingleton = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return Singleton.staticSingleton;
    }

    public static void main(String[] args) {
        System.out.println(StaticSingleton.getInstance());
        System.out.println(StaticSingleton.getInstance());
    }
}
