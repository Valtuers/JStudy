package com.Concurrent.Atomic;

import java.util.concurrent.atomic.*;

/**
 * 原子类
 */
public class AtomicDemo {

    public void atomicInteger() {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.println("AtomicInteger--->"+atomicInteger.incrementAndGet());
                }
            }).start();
        }
    }

    public void adder() {
        LongAdder longAdder = new LongAdder();
        longAdder.add(0);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    longAdder.increment();
                    System.out.println("LongAdder--->"+longAdder.longValue());
                }
            }).start();
        }

    }

    public void accumnlator() {
        LongAccumulator longAccumulator = new LongAccumulator((oVal, nVal) ->{
            long max = Math.max(nVal, oVal);
            System.out.println("新值->"+nVal+",旧值->"+oVal);
            return max;
        }, 1L);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    longAccumulator.accumulate(finalI*j);
                    System.out.println("longAccumulator-"+finalI+"-"+j+"->"+longAccumulator.get());
                }
            }).start();
        }
    }

    public void atomicArray() {
        int[] arr = new int[]{-1,-1,-1,-1,-1,0};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    atomicIntegerArray.set(finalI,finalI);
                    atomicIntegerArray.incrementAndGet(5);
                    System.out.println(finalI+"--->"+atomicIntegerArray.toString());
                }
            }).start();
        }
    }

    public void atomicField() {
        AtomicLongFieldUpdater<TestNum> fieldUpdater = AtomicLongFieldUpdater.newUpdater(TestNum.class, "num");
        TestNum testNum = new TestNum(0L);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    fieldUpdater.incrementAndGet(testNum);
                    System.out.println(testNum.getNum());
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
//        atomicDemo.atomicInteger();
//        atomicDemo.adder();
//        atomicDemo.accumnlator();
//        atomicDemo.atomicArray();
        atomicDemo.atomicField();
    }
}

class TestNum {
    volatile long num;

    public TestNum(long num) {
        this.num = num;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }
}