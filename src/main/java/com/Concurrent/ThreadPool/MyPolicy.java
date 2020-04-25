package com.Concurrent.ThreadPool;

import java.util.concurrent.*;

/**
 * 线程池拒绝策略
 * AbortPolicy：该策略直接抛出异常，阻止系统正常工作
 * CallerRunsPolicy：只要线程池没有关闭，该策略直接在调用者线程中，执行当前被丢弃的任务（叫老板帮你干活）
 * DiscardPolicy：直接啥事都不干，直接把任务丢弃
 * DiscardOldestPolicy：丢弃最老的一个请求（任务队列里面的第一个），再尝试提交任务
 */
public class MyPolicy implements RejectedExecutionHandler {
    //自定义拒绝策略
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("线程池满了");
    }

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 3L, TimeUnit.SECONDS, linkedBlockingQueue, new MyPolicy());

        for (int i = 0; i < 35; i++) {
            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadPoolExecutor.getPoolSize());
            });
        }
    }
}
