package com.Concurrent.Container;

import java.util.concurrent.CopyOnWriteArrayList;

public class ASyncContainerDemo {

    public void copyOnWrite(){
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("demo"+i);

        }
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                list.forEach(e -> {
                    if(e.equals("demo3")){
                        list.remove(e);
                    }
                });
            }).start();
        }
    }

    public static void main(String[] args) {
        ASyncContainerDemo aSyncContainerDemo = new ASyncContainerDemo();
        aSyncContainerDemo.copyOnWrite();
    }
}
