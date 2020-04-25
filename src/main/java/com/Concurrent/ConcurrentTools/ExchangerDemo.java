package com.Concurrent.ConcurrentTools;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    /**
     * 用于交换数据
     * 它提供一个同步点，在这个同步点两个线程可以交换彼此的数据。
     * 这两个线程通过exchange方法交换数据， 如果第一个线程先执行exchange方法，它会一直等待第二个线程也执行exchange，当两个线程都到达同步点时，这两个线程就可以交换数据，将本线程生产出来的数据传递给对方。
     * 因此使用Exchanger的重点是成对的线程使用exchange()方法，当有一对线程达到了同步点，就会进行交换数据。因此该工具类的线程对象是【成对】的。
     */
    public static void main(String[] args) {
        Exchanger<String> stringExchanger = new Exchanger<>();

        String str1 = "lalala";
        String str2 = "hahaha";

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"初始值："+str1);
            try {
                String changeStr = stringExchanger.exchange(str1);
                System.out.println(Thread.currentThread().getName()+"交换值："+changeStr);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程1").start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"初始值："+str2);
            try {
                String changeStr = stringExchanger.exchange(str2);
                System.out.println(Thread.currentThread().getName()+"交换值："+changeStr);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程2").start();
    }
}
