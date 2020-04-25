package com.Concurrent.Communication;

public class Communication {
    /*
        线程1的run方法里调用线程2的join方法，线程1会等线程2结束之后才继续运行
     */
    public void join() {
        Thread thread1 = new Thread(() -> {
            System.out.println("线程1运行");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1结束");
        });
        thread1.start();
        new Thread(() -> {
            System.out.println("线程2运行");
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2结束");
        }).start();
    }

    /*
        自动为每个线程单独存放一份变量副本
     */
    public void threadLocal() {
        ThreadLocal<Integer> num = ThreadLocal.withInitial(() -> 0);

        for (int i = 1; i < 3; i++) {
            int sleepI = i;
            new Thread(() -> {
                while (true) {
                    Integer myNum = num.get();
                    ++myNum;
                    try {
                        Thread.sleep(sleepI *1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"----->"+myNum);
                    num.set(myNum);
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        Communication communication = new Communication();
        communication.join();
        communication.threadLocal();
    }
}
