package com.Concurrent.ConcurrentTools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    /**
     * CyclicBarrier(栅栏)
     * 一般用于一组线程互相等待到某个状态，然后这一组线程再同时执行；可重复使用
     */
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(8);

        for (int i = 0; i < 8; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    Thread.sleep(finalI *1000L);
                    System.out.println(Thread.currentThread().getName()+"准备就绪~~~");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"开跑！！！");
            }).start();
        }
    }
}
