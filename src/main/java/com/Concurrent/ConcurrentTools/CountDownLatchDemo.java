package com.Concurrent.ConcurrentTools;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    /**
     * await(): 进入等待的状态
     * countDown()：唤醒现车定，计数器减一
     *
     * 一般用于某个线程等待若干个线程执行完成后再执行；不可重复使用
     */
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(8);

        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("800米比赛结束！！！");
            }
        }).start();

        for (int i = 0; i < 8; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    Thread.sleep(finalI *1000L);
                    System.out.println(Thread.currentThread().getName()+"-到达终点");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }
    }
}
