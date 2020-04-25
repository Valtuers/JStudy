package com.Concurrent.ConcurrentTools;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    /**
     * (信号量)
     * 控制并发数量
     * 使用场景：接口限流
     */
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"开始执行");
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"执行结束");
                }
            }).start();
        }
    }
}
