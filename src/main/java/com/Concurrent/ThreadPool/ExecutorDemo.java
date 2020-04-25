package com.Concurrent.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorDemo {
    /**
     * newCachedThreadPool：创建一个可以根据需要创建新线程的线程池，如果有空闲线程，优先使用空闲的线程
     * newFixedThreadPool：创建一个固定大小的线程池，在任何时候，最多只有N个线程在处理任务
     * newScheduledThreadPool：能延迟执行、定时执行的线程池
     * newWorkStealingPool：工作窃取，使用多个队列来减少竞争
     * newSingleThreadExecutor：单一线程的线程次，只会使用唯一一个线程来执行任务，即使提交再多的任务，也都是会放到等待队列里进行等待
     * newSingleThreadScheduledExecutor：单线程能延迟执行、定时执行的线程池
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ExecutorService executorService2 = Executors.newWorkStealingPool();
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();

        executorService1.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });
    }
}
