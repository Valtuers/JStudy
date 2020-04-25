package com.Concurrent.Container;

import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

public class SyncContainerDemo {

    public void vector() {
        Vector<String> stringVector = new Vector<>();
        for (int i = 0; i < 100; i++) {
            stringVector.add("demo"+i);
        }
        Iterator<String> iterator = stringVector.iterator();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                //同步容器并发操作需要加锁
                synchronized (iterator){
                    while (iterator.hasNext()){
                        String next = iterator.next();
                        if(next.equals("demo3")){
                            iterator.remove();
                        }

                    }
                }
            }).start();
        }
    }

    /*
        阻塞队列，适合用于生产消费关系中的中间商，管理库存
     */
    public void linkedBlockingQueue() {
        LinkedBlockingQueue<String> link = new LinkedBlockingQueue<>(5);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(1000L);
                        link.put("货物");
                        System.out.println("生产货物，还剩："+link.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"生产商").start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        link.take();
                        Thread.sleep(1000L);
                        System.out.println("消费货物，还剩："+link.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"消费商").start();
        }
    }

    public static void main(String[] args) {
        SyncContainerDemo syncContainerDemo = new SyncContainerDemo();
//        syncContainerDemo.vector();
        syncContainerDemo.linkedBlockingQueue();
    }
}
