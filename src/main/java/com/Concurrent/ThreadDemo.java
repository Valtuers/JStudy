package com.Concurrent;

public class ThreadDemo {
    /**
     * 线程状态:
     * 初始(NEW)：新创建了一个线程对象，但还没有调用start()方法。
     * 运行(RUNNABLE):处于可运行状态的线程正在JVM中执行，但它可能正在等待来自操作系统的其他资源，例如处理器。
     * 阻塞(BLOCKED)：线程阻塞于synchronized锁，等待获取synchronized锁的状态。
     * 等待(WAITING)：Object.wait()、join()、 LockSupport.park(),进入该状态的线程需要等待其他线程做出一些特定动作（通知或中断）。
     * 超时等待(TIME_WAITING)：Object.wait(long)、Thread.join()、LockSupport.parkNanos()、LockSupport.parkUntil，该状态不同于WAITING，它可以在指定的时间内自行返回。
     * 终止(TERMINATED)：表示该线程已经执行完毕
     */
    private void state() throws InterruptedException {
        Object obj = new Object();
        // NEW
        Thread thread = new Thread(() -> {
            System.out.println("线程挂起1秒");
            // BLOCKED
            synchronized (obj){
                try {
                    // WATTING
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程再次挂起2秒");
            synchronized (obj){
                try {
                    // TIME_WATTING
                    obj.wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程唤醒");
        });
        // RUNNABLE
        thread.start();
        Thread.sleep(1000L);
        synchronized (obj) {
            //唤醒
            obj.notify();
        }
        // TERMINATED

    }

    /**
     * 线程的终止操作
     */
    public void interupt() throws InterruptedException {
        System.out.println("线程开始");
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(++i);
            }
        });
        thread.start();
        Thread.sleep(100L);
        thread.interrupt();
        System.out.println("线程中断");
    }

    /**
     * 线程优先级
     */
    public void priority(){
        Thread thread1 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程1");
        Thread thread2 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程2");
        Thread thread3 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程3");
        thread1.setPriority(Thread.NORM_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 守护线程
     */
    public void daemon(){
        Thread thread = new Thread(() -> {
            while(true){
                System.out.println("守护线程");
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo threadDemo = new ThreadDemo();
//        threadDemo.state();
//        threadDemo.interupt();
//        threadDemo.priority();
        threadDemo.daemon();
    }
}
