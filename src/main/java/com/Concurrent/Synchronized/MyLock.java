package com.Concurrent.Synchronized;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义可重入锁
 */
public class MyLock implements Lock {
    private boolean isLock = false;
    private Thread currentThread = null;
    public int reentryCount = 0;

    @Override
    public synchronized void lock() {
        if(isLock && Thread.currentThread() != currentThread){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        currentThread = Thread.currentThread();
        isLock = true;
        reentryCount++;
        System.out.println(reentryCount);
    }

    @Override
    public synchronized void unlock() {
        if(Thread.currentThread() == currentThread){
            reentryCount--;
            if(reentryCount == 0){
                notify();
                isLock = false;
            }
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }
}

class TestMyLock{
    public Lock myLock = new MyLock();
    public void methodA(){
        myLock.lock();
        System.out.println("进入方法A");
        methodB();
        myLock.unlock();
    }
    public void methodB(){
        myLock.lock();
        System.out.println("进入方法B");
        myLock.unlock();
    }

    ReentrantLock lock = new ReentrantLock();
    int i = 0;
    public void create(){
        lock.lock();
        try {
            ++i;
            System.out.println(i);
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TestMyLock testMyLock = new TestMyLock();
        testMyLock.methodA();
        for (int i=0;i<3;i++){
            new Thread(testMyLock::create).start();
        }
    }
}
