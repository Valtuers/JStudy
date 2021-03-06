package com.DesignMode.Creational.Singleton;


public class LazySingleton {
    private static volatile LazySingleton lazySingleton = null;

    private LazySingleton(){
    }

    public static LazySingleton getInstance(){
        if(lazySingleton == null){
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LazySingleton.class) {
                if(lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    public static void main(String[] args) {
        LazySingleton l1 = LazySingleton.getInstance();
        LazySingleton l2 = LazySingleton.getInstance();
        System.out.println(l1 == l2);

        int f = 50;
        while(f > 0){
            new Thread(() -> {
                int n = 50;
                while(n > 0){
                    System.out.println(LazySingleton.getInstance());
                    --n;
                }
            }).start();
            --f;
        }
    }
}
