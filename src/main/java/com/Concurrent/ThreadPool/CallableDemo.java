package com.Concurrent.ThreadPool;

import java.util.concurrent.*;

public class CallableDemo implements Callable {
    /**
     * Future与Callable、FutureTask
     * Callable与Runable功能相似，Callable的call有返回值，可以返回给客户端，而Runable没有返回值
     * 一般情况下，Callable与FutureTask一起使用，或者通过线程池的submit方法返回相应的Future
     * Future就是对于具体的Runnable或者Callable任务的执行结果进行取消、查询是否完成、获取结果、设置结果操作。get方法会阻塞，直到任务返回结果
     * FutureTask则是一个RunnableFuture，而RunnableFuture实现了Runnbale又实现了Futrue这两个接口
     */
    @Override
    public String call() throws Exception {
        Thread.sleep(1000L);
        return "1111";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 3L, TimeUnit.SECONDS, linkedBlockingQueue);
        Future<String> submit = null;

        for (int i = 0; i < 10; i++) {
            submit = threadPoolExecutor.submit(new CallableDemo());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(submit.get());
        }

    }
}
