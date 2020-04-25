package com.Concurrent.JVM;

public class Reorder {
    /**
     * 指令重排序
     * 什么是指令重排序？
     * 重排序是指编译器和处理器为了优化程序性能而对指令序列进行重新排序的一种手段。
     *
     * 数据依赖性
     * 编译器和处理器在重排序时，会遵守数据依赖性，编译器和处理器不会改变存在数据依赖关系的两个操作的执行顺序。（仅针对单个处理器中执行的指令序列和单个线程中执行的操作，不同处理器之间和不同线程之间的数据依赖性不被编译器和处理器考虑。）
     *
     * 两操作访问同一个变量，其两个操作中有至少一个写操作，此时就存在依赖性
     *
     * 写后读 a=0 b=a
     * 读后写 a=b b=1
     * 写后写 a=1 a=2 a=1,b=1
     * 写后读 a=0 b=a 正确b=0 错误b=1
     *
     * as-if-serial原则
     * 不管怎么重排序（编译器和处理器为了提高并行度），（单线程）程序的执行结果不能被改变。
     */
    static int a=0,b=0,x=0,y=0;
    public static void main(String[] args) throws InterruptedException {
        boolean flag = true;
        int i=0;

        while (flag) {
            ++i;
            Thread thread = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread thread2 = new Thread(() -> {
                b = 1;
                y = a;
            });
            thread.start();
            thread2.start();

            thread.join();
            thread2.join();
            //四种可能
            /*
             * x=0，y=1
             * x=1, y=0
             * x=1, y=1
             * x=0, y=0
             */
            System.out.println("第"+i+"次 "+"x===>"+x+"  y===>"+y);

            //当发生 x和y都等于0时，证明发生指令重排序
            if(x == 0 && y == 0){
                flag = false;
            }else {
                x = 0;
                y = 0;
                a = 0;
                b = 0;
            }
        }
    }
}
