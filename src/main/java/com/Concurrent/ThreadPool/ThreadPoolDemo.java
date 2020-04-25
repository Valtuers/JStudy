package com.Concurrent.ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    /**
     * ThreadPoolExecutor: 参数详解
     * corePoolSize：核心线程池大小 cSize
     * maximumPoolSize：线程池最大容量 mSize
     * keepAliveTime：当线程数量大于核心时，多余的空闲线程在终止之前等待新任务的最大时间。
     * unit：时间单位
     * workQueue:工作队列 nWorks
     * ThreadFactory：线程工厂
     * handler：拒绝策略
     *
     * 运行机制：
     * 通过new创建线程池时，除非调用prestartAllCoreThreads方法初始化核心线程，否则此时线程池中有0个线程，即使工作队列中存在多个任务，同样不会执行
     *
     * 任务数X计算：
     * x <= cSize 只启动x个线程
     * x >= cSize && x < nWorks + cSize 会启动 <= cSize 个线程 其他的任务就放到工作队列里
     * x > cSize && x > nWorks + cSize
     * x-(nWorks) <= mSize 会启动x-(nWorks)个线程
     * x-(nWorks) > mSize 会启动mSize个线程来执行任务，其余的执行相应的拒绝策略
     */
    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> link = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 20, 3L, TimeUnit.SECONDS, link);
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
