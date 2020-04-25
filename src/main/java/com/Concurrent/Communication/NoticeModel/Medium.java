package com.Concurrent.Communication.NoticeModel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 中间商
 */
public class Medium {
    private int num = 0;
    private static final int TOTAL = 20;

    //使用Condition可以指定哪些线程去等待或唤醒
    private Lock lock = new ReentrantLock();
    private Condition consumerCondition = lock.newCondition();
    private Condition producerCondition = lock.newCondition();

    public void put() {
        lock.lock();
        try {
            //判断当前库存，是否已经是最大的库存容量
            if(num < TOTAL) {
                //如果不是，生产完成之后，通知消费者进行消费
                System.out.println("新增库存------>当前库存："+ ++num);
                consumerCondition.signalAll();
            }else {
                //如果是，则通知生产者等待
                try {
                    System.out.println("新增库存------>库存已满："+num);
                    producerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } finally {
            lock.unlock();
        }
    }

    public void take() {
        lock.lock();
        try {
            //判断当前库存是否不足
            if (num > 0) {
                //如果充足，在消费完成之后通知生产者进行生产
                System.out.println("消费库存------>当前库存容量："+ --num);
                producerCondition.signalAll();
            }else {
                //如果不足，通知消费者停止消费
                System.out.println("消费库存------>库存不足："+num);
                try {
                    consumerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } finally {
            lock.unlock();
        }
    }
}
