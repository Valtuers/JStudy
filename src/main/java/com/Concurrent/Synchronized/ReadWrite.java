package com.Concurrent.Synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWrite {
    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    int i = 0;
    int j = 0;

    public void out() {
        readLock.lock();
        try{
            System.out.println("i===>"+i+",j====>"+j);
        }finally {
            readLock.unlock();
        }
    }
    public void create() {
        writeLock.lock();
        try {
            ++i;
            Thread.sleep(500L);
            ++j;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
           writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWrite readWrite = new ReadWrite();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                readWrite.create();
                readWrite.out();
            }).start();
        }
        new Thread(readWrite::create,"写线程").start();
        new Thread(readWrite::out,"读线程").start();
    }
}
