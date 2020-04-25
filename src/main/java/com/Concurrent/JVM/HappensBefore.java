package com.Concurrent.JVM;

public class HappensBefore {
    /**
     * 先行发生原则 happens-before
     * 判断数据是有有竞争、线程是否安全的主要依据
     *
     * 1.程序次序规则：同一个线程内，按照代码出现的顺序，前面的代码先行于后面的代码，准确的说是控制流顺序，因为要考虑到分支和循环结构。
     *
     * 管程锁定规则：一个unlock操作先行发生于后面（时间上）对同一个锁的lock操作。
     * volatile变量规则：对一个volatile变量的写操作先行发生于后面（时间上）对这个变量的读操作
     * 线程启动规则：Thread的start( )方法先行发生于这个线程的每一个操作。
     * 线程终止规则：线程的所有操作都先行于此线程的终止检测。可以通过Thread.join( )方法结束、Thread.isAlive( )的返回值等手段检测线程的终止。
     * 线程中断规则：对线程interrupt( )方法的调用先行发生于被中断线程的代码检测到中断事件的发生，可以通过Thread.interrupt( )方法检测线程是否中断
     * 对象终结规则：一个对象的初始化完成先行于发生它的finalize（）方法的开始。
     * 传递性：如果操作A先行于操作B，操作B先行于操作C，那么操作A先行于操作C。
     * 为什么要有该原则？ 无论jvm或者cpu，都希望程序运行的更快。如果两个操作不在上面罗列出来的规则里面，那么久可以对他们进行任意的重排序。
     *
     * 时间先后顺序与先行发生的顺序之间基本没有太大的关系。
     */
}