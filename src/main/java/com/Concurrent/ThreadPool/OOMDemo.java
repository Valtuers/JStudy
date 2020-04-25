package com.Concurrent.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模拟OOM
 * 修改-VM Options:
 * -Xms60m
 * -Xmx60m
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=G:\IntelliJIDEA\project\JStudy\src\main\java\com\Concurrent\ThreadPool
 */
public class OOMDemo {
    /**
     * 尽量避免使用Executor框架创建线程池
     *
     * newFixedThreadPool newSingleThreadExecutor允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
     * newCachedThreadPool newScheduledThreadPool允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM
     *
     * 创建线程时用的内存并不是我们制定jvm堆内存，而是系统的剩余内存。（电脑内存-系统其它程序占用的内存-已预留的jvm内存）
     *
     * 创建线程池时，核心线程数不要过大
     *
     * 相应的逻辑，发生异常时要处理
     *
     * submit 如果发生异常，不会立即抛出，而是在get的时候，再抛出异常
     *
     * execute 直接抛出异常
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        while (true) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(300L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
